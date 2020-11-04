package br.com.simuladorvendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class acessorios extends AppCompatActivity {
    private RadioButton radioButton1,radioButton2,radioButton3;
    private TextView valor1,valor2,valor3;
    private Button btnRetornar, btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acessorios);

        radioButton1 =findViewById(R.id.radioButton1);
        radioButton2 =findViewById(R.id.radioButton2);
        radioButton3 =findViewById(R.id.radioButton3);
        valor1= findViewById(R.id.valor1);
        valor2= findViewById(R.id.valor2);
        valor3= findViewById(R.id.valor3);

        btnRetornar=findViewById(R.id.retornar);
        btnCancelar=findViewById(R.id.cancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                setResult(0);
                finish();
            }
        });
        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent= getIntent();
                float valor =0;
                String descricao="";

                if(radioButton1.isChecked()){
                    valor=30000;
                    descricao=radioButton1.getText().toString();
                }
                if (radioButton2.isChecked()){
                    valor = 35000;
                    descricao=radioButton2.getText().toString();
                }
                if (radioButton3.isChecked()){
                    valor=45000;
                    descricao=radioButton3.getText().toString();
                }

                intent.putExtra("valor",valor);
                intent.putExtra("descricao",descricao);
                setResult(2,intent);
                finish();
            }
        });
    }
}