package br.com.caspinheiro.aulas.agendacontatos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.caspinheiro.aulas.agendacontatos.adapter.ContatoAdapter;
import br.com.caspinheiro.aulas.agendacontatos.dao.ContatoDAO;
import br.com.caspinheiro.aulas.agendacontatos.model.Contato;
import br.com.caspinheiro.aulas.agendacontatos.model.ContatoComTipo;
import br.com.caspinheiro.aulas.agendacontatos.singleton.SingletonDatabase;
import br.com.caspinheiro.aulas.agendacontatos.util.AppDatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected Button btnCadastrar;
    protected ListView lvwContatos;
    protected final int CONTATO_ACTIVITY = 1;

    protected void listaContatos(){

        new AsyncTask<Void, Void, List<ContatoComTipo>>(){
            @Override
            protected List<ContatoComTipo> doInBackground(Void... voids) {
                AppDatabase appDatabase = SingletonDatabase.getInstance(MainActivity.this);
                ContatoDAO dao = appDatabase.contatoDAO();
                List<ContatoComTipo> contatos = dao.listarTodos();
                return contatos;
            }

            @Override
            protected void onPostExecute(List<ContatoComTipo> contatos) {
                super.onPostExecute(contatos);

                ContatoAdapter contatoAdapter = new ContatoAdapter(contatos, MainActivity.this);
                lvwContatos.setAdapter(contatoAdapter);

            }
        }.execute();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == CONTATO_ACTIVITY && resultCode == 1 ){
            listaContatos();
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        lvwContatos = findViewById(R.id.lvwContatos);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, ContatoActivity.class);
                startActivityForResult( intent, CONTATO_ACTIVITY );
            }
        });

        lvwContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato contato = (Contato)parent.getItemAtPosition(position);

                Intent intent = new Intent( MainActivity.this, ContatoActivity.class);
                intent.putExtra("contato", contato);
                startActivityForResult( intent, CONTATO_ACTIVITY );
            }
        });

        listaContatos();
    }
}
