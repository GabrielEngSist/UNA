package br.com.caspinheiro.aulas.agendacontatos;

import androidx.appcompat.app.AppCompatActivity;
import br.com.caspinheiro.aulas.agendacontatos.adapter.TipoContatoAdapter;
import br.com.caspinheiro.aulas.agendacontatos.model.Contato;
import br.com.caspinheiro.aulas.agendacontatos.model.TipoContato;
import br.com.caspinheiro.aulas.agendacontatos.singleton.SingletonDatabase;
import br.com.caspinheiro.aulas.agendacontatos.util.AppDatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class ContatoActivity extends AppCompatActivity {

    protected Button btnSalvar, btnCancelar, btnExcluir;
    protected EditText txtNome;
    protected EditText txtTelefone;
    protected EditText txtTelefoneCelular;
    protected EditText txtEmail;
    protected Contato contato;
    protected Spinner spTipoContato;


    protected boolean validarCampos(){
        if( txtNome.getText().toString().isEmpty() ){
            Toast.makeText(this, "Nome não informado!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    protected void excluir(Contato contato){

        new AsyncTask<Contato, Void, Boolean>(){

            @Override
            protected Boolean doInBackground(Contato... contatos) {
                AppDatabase db = SingletonDatabase.getInstance(ContatoActivity.this);
                db.contatoDAO().delete(contatos[0]);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                ContatoActivity.this.setResult(1);
                ContatoActivity.this.finish();
            }
        }.execute(contato);
    }

    protected void salvar( Contato contato ){
        new AsyncTask<Contato, Void, Boolean>(){

            @Override
            protected Boolean doInBackground(Contato... contatos) {
                AppDatabase db = SingletonDatabase.getInstance(ContatoActivity.this);

                if( contatos[0].getCodigo() == null ) {
                    db.contatoDAO().insert(contatos[0]);
                } else {
                    db.contatoDAO().update(contatos[0]);
                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);

                if( aBoolean == true ) {
                    Toast.makeText(ContatoActivity.this,
                        "Registro salvo com sucesso", Toast.LENGTH_LONG).show();
                    ContatoActivity.this.setResult(1);
                    ContatoActivity.this.finish();
                }
            }
        }.execute(contato);

    }

    protected void carregaTipoContato(){
        new AsyncTask<Void, Void, List<TipoContato>>(){

            @Override
            protected List<TipoContato> doInBackground(Void... voids) {
                AppDatabase db = SingletonDatabase.getInstance(ContatoActivity.this);
                List<TipoContato> tipoContatoes = db.tipoContatoDAO().listaTodos();
                return tipoContatoes;
            }

            @Override
            protected void onPostExecute(List<TipoContato> tipoContatoes) {
                super.onPostExecute(tipoContatoes);
                TipoContatoAdapter tipoContatoAdapter = new TipoContatoAdapter( ContatoActivity.this, tipoContatoes);
                spTipoContato.setAdapter(tipoContatoAdapter);

            }
        }.execute();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnExcluir = findViewById(R.id.btnExcluir);
        txtNome = findViewById(R.id.txtNome);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtTelefoneCelular = findViewById(R.id.txtTelefoneCelular);
        txtEmail = findViewById(R.id.txtEmail);

        spTipoContato = findViewById(R.id.spTipoContato);

        carregaTipoContato();


        Intent intent = getIntent();
        if( intent.hasExtra("contato") ){
            contato = (Contato)intent.getSerializableExtra("contato");
            txtNome.setText( contato.getNome() );
            txtEmail.setText( contato.getEmail() );
            txtTelefone.setText( contato.getTelefone() );
            txtTelefoneCelular.setText( contato.getTelefoneCelular() );

        } else {
            contato = new Contato();
        }

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatoActivity.this.finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( validarCampos() == true ){
                    contato.setNome(txtNome.getText().toString());
                    contato.setTelefone(txtTelefone.getText().toString());
                    contato.setTelefoneCelular(txtTelefoneCelular.getText().toString());
                    contato.setEmail(txtEmail.getText().toString());

                    TipoContato tipoContato = (TipoContato)spTipoContato.getSelectedItem();
                    contato.setCodigoTipoContato( tipoContato.getCodigo()  );

                    salvar(contato);
                }
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( contato.getCodigo() != null ){
                    excluir(contato);
                }
            }
        });

    }
}
