package br.com.simuladorvendas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {

    private TextView lblVersao,lblVersaoSelecionada,lblTotalVersao,lblAcessorio,
            lblAcessorioSelecionado,lblTotalversao,lblTotalAcessorio,lblTotalgeral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblVersao = findViewById(R.id.lblVersao);
        lblVersaoSelecionada=findViewById(R.id.lblVersaoSelecionada);
        lblTotalVersao = findViewById(R.id.lblTotalVersao);
        lblAcessorio = findViewById(R.id.lblAcessorio);
        lblTotalAcessorio = findViewById(R.id.lblTotalAcessorio);
        lblAcessorioSelecionado = findViewById(R.id.lblAcessorioSelecionado);
        lblTotalgeral = findViewById(R.id.lblTotalGeral);
        lblAcessorio.setOnClickListener(cliequeBotaoAcessorio);
        lblVersao.setOnClickListener(cliqueBotaoVersao);
        lblVersaoSelecionada.setOnClickListener(cliqueBotaoVersao);
        lblTotalVersao.setOnClickListener(cliqueBotaoVersao);
        lblTotalAcessorio.setOnClickListener(cliequeBotaoAcessorio);

    }
    View.OnClickListener cliequeBotaoAcessorio = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,acessorios.class);
            startActivityForResult(intent,1000);        }
    };

    View.OnClickListener cliqueBotaoVersao = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,VersaoActivity.class);
            startActivityForResult(intent,1000);
        }
    };
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        float total = 0;
        String totalGeral = lblTotalgeral.getText().toString()
                .replace(" ", "")
                .replace("TOTALR$", "")
                .replace(".","")
                .replace(",",".");
        Locale ptBr = new Locale("pt", "BR");

        if( requestCode==1000 && resultCode == 1){
            total = parseFloat(totalGeral);
            float valor = data.getFloatExtra("valor",0);
            String descricao = data.getStringExtra("descricao");
            total = total + valor;
            lblVersaoSelecionada.setText(descricao);
            String totalFormatado = NumberFormat.getCurrencyInstance(ptBr).format(valor);
            lblTotalVersao.setText(totalFormatado);
        }
        if( requestCode==1000 && resultCode == 2){
            total = parseFloat(totalGeral);
            float valor = data.getFloatExtra("valor",0);
            String descricao = data.getStringExtra("descricao");
            total = total + valor;
            lblAcessorioSelecionado.setText(descricao);
            String totalFormatado = NumberFormat.getCurrencyInstance(ptBr).format(valor);
            lblTotalAcessorio.setText(totalFormatado);
        }
        lblTotalgeral.setText("TOTAL "+NumberFormat.getCurrencyInstance(ptBr).format(total));
    }
}