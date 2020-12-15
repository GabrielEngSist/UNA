package com.lucas.calculodescontovaletransporte;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final int PARAMETRIZAR_ACTIVITY = 1;
    private Double valorValeTransporte = 4.5;
    private Double percentualDesconto = 6.0;
    private CheckBox ckbIda;
    private CheckBox ckbVolta;
    private EditText txtNome;
    private EditText txtSalario;
    private EditText txtNumeroDias;
    private TextView lblValorTotalDesconto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == PARAMETRIZAR_ACTIVITY && resultCode == RESULT_OK && data != null ){
            valorValeTransporte = data.getDoubleExtra("valorValeTransporte", valorValeTransporte);
            percentualDesconto = data.getDoubleExtra("percentualDesconto", percentualDesconto);
        }
    }

    private void iniciarComponentes() {
        this.ckbIda = findViewById(R.id.ckbIda);
        this.ckbVolta = findViewById(R.id.ckbVolta);
        this.txtNome = findViewById(R.id.txtNome);
        this.txtSalario = findViewById(R.id.txtSalario);
        this.txtNumeroDias = findViewById(R.id.txtNumeroDias);
        this.lblValorTotalDesconto = findViewById(R.id.lblValorTotalDesconto);
    }

    public void calcular(View view) {
        if(validarInputs()){
            int multiplicador = (this.ckbIda.isChecked() ? 1 : 0) + (this.ckbVolta.isChecked() ? 1 : 0);
            int numeroDias = Integer.parseInt(this.txtNumeroDias.getText().toString());
            double valorSalario = Double.parseDouble(this.txtSalario.getText().toString());
            Double valorGastoTransporte = multiplicador * valorValeTransporte * numeroDias;
            Double valorDescontoPercentual = valorSalario * percentualDesconto / 100;
            this.lblValorTotalDesconto.setText(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(Math.min(valorGastoTransporte, valorDescontoPercentual)));
        }
    }

    private boolean validarInputs() {
        boolean nomePreenchido = !this.txtNome.getText().toString().isEmpty();
        boolean salarioPreenchido = !(this.txtSalario.getText().toString().isEmpty() || Double.parseDouble(this.txtSalario.getText().toString()) < 0);
        boolean numeroDiasPreenchido = !(this.txtNumeroDias.getText().toString().isEmpty() || Integer.parseInt(this.txtNumeroDias.getText().toString()) < 0 );

        if(!nomePreenchido){
            Toast.makeText(this, "O nome deve ser preenchido!", Toast.LENGTH_LONG).show();
        }

        if(!salarioPreenchido){
            Toast.makeText(this, "O salário deve ser preenchido!", Toast.LENGTH_LONG).show();
        }

        if(!numeroDiasPreenchido){
            Toast.makeText(this, "O nuemero de dias deve ser preenchido!", Toast.LENGTH_LONG).show();
        }

        return nomePreenchido && salarioPreenchido && numeroDiasPreenchido;
    }

    public void parametrizar(View view) {
        Intent intent = new Intent(MainActivity.this, ParametrizarActivity.class);
        intent.putExtra("valorValeTransporte", valorValeTransporte);
        intent.putExtra("percentualDesconto", percentualDesconto);
        startActivityForResult( intent, PARAMETRIZAR_ACTIVITY);
    }
}