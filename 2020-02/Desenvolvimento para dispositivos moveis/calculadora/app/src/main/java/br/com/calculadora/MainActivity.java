package br.com.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.calculadora.calculatorBl.exceptions.AttemptToDivideByZero;
import br.com.calculadora.calculatorBl.exceptions.InvalidOperationException;
import br.com.calculadora.calculatorBl.operations.OperationFactory;
import br.com.calculadora.domain.enums.Botoes;
import br.com.calculadora.domain.enums.Operacoes;

public class MainActivity extends AppCompatActivity {
    private TextView txtDisplay;
    private List<String> operators = new ArrayList<String>(
            Arrays.asList("+", "-", "*", "/", "CE", "="));
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private Button btnCE,btnIgual,btnMultiplicar,btnDividir,btnSomar,btnSubtrair;
    private double valor1,valor2,resultado;
    private String operacao="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = findViewById(R.id.txtDisplay);
        fillButtons();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        btn0.setOnClickListener(cliqueBotaoNumerico);
        btn1.setOnClickListener(cliqueBotaoNumerico);
        btn2.setOnClickListener(cliqueBotaoNumerico);
        btn3.setOnClickListener(cliqueBotaoNumerico);
        btn4.setOnClickListener(cliqueBotaoNumerico);
        btn5.setOnClickListener(cliqueBotaoNumerico);
        btn6.setOnClickListener(cliqueBotaoNumerico);
        btn7.setOnClickListener(cliqueBotaoNumerico);
        btn8.setOnClickListener(cliqueBotaoNumerico);
        btn9.setOnClickListener(cliqueBotaoNumerico);
        btnSomar.setOnClickListener(cliqueBotaoOperacao);
        btnSubtrair.setOnClickListener(cliqueBotaoOperacao);
        btnMultiplicar.setOnClickListener(cliqueBotaoOperacao);
        btnDividir.setOnClickListener(cliqueBotaoOperacao);
        btnIgual.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Button botao = (Button)v;
                String valorTexto = (String)botao.getText();
                Botoes botaoPressioado = Botoes.fromString(valorTexto);

                switch (botaoPressioado){
                    case NUMERICO:
                        break;
                    case CE:
                        break;
                    case IGUAL:
                        break;
                    default:
                        valor2 = Double.parseDouble(txtDisplay.getText().toString());
                        resultado = executaOperacao(valor1, valor2, operacao);
                }

                valor2 = Double.parseDouble(txtDisplay.getText().toString());

                txtDisplay.setText(Double.toString(resultado));
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operacao="";
                txtDisplay.setText("");
            }
        });
    }

    private double executaOperacao(double valor1, double valor2, String operacao) {
        double result = 0;

        try {
            resultado = new OperationFactory(Operacoes.fromString(operacao))
                    .getOperation()
                    .calcular(valor1, valor2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private void fillButtons() {
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);

        btnCE=findViewById(R.id.btnCE);
        btnIgual=findViewById(R.id.btnIgual);
        btnMultiplicar=findViewById(R.id.btnMultiplicar);
        btnDividir=findViewById(R.id.btnDividir);
        btnSomar=findViewById(R.id.btnSomar);
        btnSubtrair=findViewById(R.id.btnSubtrair);
    }

    View.OnClickListener getResult = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener cliqueBotaoNumerico = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button botaoPressionado = (Button)v;
            txtDisplay.setText(txtDisplay.getText().toString()+botaoPressionado.getText());
        }
    };
     View.OnClickListener cliqueBotaoOperacao = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button botaoPressionado= (Button)v;
            operacao=botaoPressionado.getText().toString();
            valor1 = Double.parseDouble(txtDisplay.getText().toString());
            txtDisplay.setText("");
        }
    };

}