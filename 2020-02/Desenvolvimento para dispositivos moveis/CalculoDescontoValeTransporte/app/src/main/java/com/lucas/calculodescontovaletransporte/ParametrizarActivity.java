package com.lucas.calculodescontovaletransporte;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ParametrizarActivity extends AppCompatActivity {

    private EditText txtPercentualDesconto;
    private EditText txtValorValeTransporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametrizar);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.txtPercentualDesconto = findViewById(R.id.txtPercentualDesconto);
        this.txtValorValeTransporte = findViewById(R.id.txtValorValeTransporte);
        Intent intent = getIntent();
        if(intent.hasExtra("valorValeTransporte")){
            this.txtValorValeTransporte.setText(String.valueOf(intent.getDoubleExtra("valorValeTransporte", 0.0)));
        }

        if(intent.hasExtra("percentualDesconto")){
            this.txtPercentualDesconto.setText(String.valueOf(intent.getDoubleExtra("percentualDesconto", 0.0)));
        }
    }

    public void confirmar(View view){
        if(validarCampos()){
            Intent intent = new Intent();
            intent.putExtra("valorValeTransporte", Double.parseDouble(txtValorValeTransporte.getText().toString()));
            intent.putExtra("percentualDesconto", Double.parseDouble(txtPercentualDesconto.getText().toString()));
            ParametrizarActivity.this.setResult(RESULT_OK, intent);
            ParametrizarActivity.this.finish();
        }
    }

    private boolean validarCampos() {
        boolean valorValeTransportePreenchido = !(this.txtValorValeTransporte.getText().toString().isEmpty() || Double.parseDouble(this.txtValorValeTransporte.getText().toString()) < 0);
        boolean percentualDescontoPreenchido = !(this.txtPercentualDesconto.getText().toString().isEmpty() || Double.parseDouble(this.txtPercentualDesconto.getText().toString()) < 0 );


        if(!valorValeTransportePreenchido){
            Toast.makeText(this, "O valor do vale transporte deve ser preenchido!", Toast.LENGTH_LONG).show();
        }

        if(!percentualDescontoPreenchido){
            Toast.makeText(this, "O percentual de desconto deve ser preenchido!", Toast.LENGTH_LONG).show();
        }

        return valorValeTransportePreenchido && percentualDescontoPreenchido;
    }

    public void cancelar(View view){
        ParametrizarActivity.this.setResult(0);
        ParametrizarActivity.this.finish();
    }
}