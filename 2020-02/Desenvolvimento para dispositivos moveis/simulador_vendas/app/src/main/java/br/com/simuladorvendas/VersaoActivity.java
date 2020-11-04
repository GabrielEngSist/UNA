package br.com.simuladorvendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class VersaoActivity extends AppCompatActivity {

    private TextView lblValor1, lblValor2,lblValor3;
    private RadioButton rbtn1,rbtn2,rbtn3;
    private Button btnRetornar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versao);

        lblValor1 =findViewById(R.id.lblValor1);
        lblValor2 =findViewById(R.id.lblValor2);
        lblValor3 =findViewById(R.id.lblValor3);
        rbtn1= findViewById(R.id.rbtn1);
        rbtn2= findViewById(R.id.rbtn2);
        rbtn3= findViewById(R.id.rbtn3);

        btnRetornar=findViewById(R.id.btnRetornar);
        btnCancelar=findViewById(R.id.btnCancelar);

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

                if(rbtn1.isChecked()){
                    valor=94990;
                    descricao=rbtn1.getText().toString();
                }
                if (rbtn2.isChecked()){
                    valor = 119990;
                    descricao=rbtn2.getText().toString();
                }
                if (rbtn3.isChecked()){
                    valor=154990;
                    descricao=rbtn3.getText().toString();
                }

                intent.putExtra("valor",valor);
                intent.putExtra("descricao",descricao);
                setResult(1,intent);
                finish();
            }
        });

    }


}