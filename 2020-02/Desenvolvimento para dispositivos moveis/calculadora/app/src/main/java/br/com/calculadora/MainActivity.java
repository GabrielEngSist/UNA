package br.com.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtDisplay;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9, btnCE, btnResult, btnTimes, btnDivision, btnPlus, btnSubtract;
    private double leftValue, rightValue, result;
    private String operation ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = findViewById(R.id.txtDisplay);
        findButtons();
        setClickListeners();
    }

    View.OnClickListener clearPressed = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operation ="";
                txtDisplay.setText("");
            }
        };

    View.OnClickListener listenerResultPressed = new View.OnClickListener() {
            @Override
            public void onClick(View v){
            rightValue = Double.parseDouble(txtDisplay.getText().toString());
            switch (operation) {
                case "+":
                    result = leftValue + rightValue;
                    break;
                case "-":
                    result = leftValue - rightValue;
                    break;
                case "*":
                    result = leftValue * rightValue;
                    break;
                case "/":
                    result = leftValue / rightValue;
                    break;
            }
            txtDisplay.setText(Double.toString(result));
        }
        };

    private void setClickListeners() {
        btn0.setOnClickListener(listenerNumericPressed);
        btn1.setOnClickListener(listenerNumericPressed);
        btn2.setOnClickListener(listenerNumericPressed);
        btn3.setOnClickListener(listenerNumericPressed);
        btn4.setOnClickListener(listenerNumericPressed);
        btn5.setOnClickListener(listenerNumericPressed);
        btn6.setOnClickListener(listenerNumericPressed);
        btn7.setOnClickListener(listenerNumericPressed);
        btn8.setOnClickListener(listenerNumericPressed);
        btn9.setOnClickListener(listenerNumericPressed);
        btnPlus.setOnClickListener(listenerOperationPressed);
        btnSubtract.setOnClickListener(listenerOperationPressed);
        btnTimes.setOnClickListener(listenerOperationPressed);
        btnDivision.setOnClickListener(listenerOperationPressed);
        btnResult.setOnClickListener(listenerResultPressed);
        btnCE.setOnClickListener(clearPressed);
    }

    private void findButtons() {
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
        btnResult =findViewById(R.id.btnIgual);
        btnTimes =findViewById(R.id.btnMultiplicar);
        btnDivision =findViewById(R.id.btnDividir);
        btnPlus =findViewById(R.id.btnSomar);
        btnSubtract =findViewById(R.id.btnSubtrair);
    }

    View.OnClickListener listenerNumericPressed = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button botaoPressionado = (Button)v;
            txtDisplay.setText(txtDisplay.getText().toString()+botaoPressionado.getText());
        }
    };

     View.OnClickListener listenerOperationPressed = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Button botaoPressionado= (Button)v;
            operation =botaoPressionado.getText().toString();
            leftValue = Double.parseDouble(txtDisplay.getText().toString());
            txtDisplay.setText("");
        }
    };
}