package br.com.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String TIMES = "*";
    public static final String DIVISION = "/";
    public static final String STRING_EMPTY = "";

    private TextView txtDisplay;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCE, btnResult, btnTimes, btnDivision, btnPlus, btnSubtract;
    private double lastValue, result;
    private String operation = STRING_EMPTY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = findViewById(R.id.txtDisplay);
        findButtons();
        setClickListeners();
    }

    View.OnClickListener clearPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            operation = PLUS;
            txtDisplay.setText("0.0");
            result = 0;
            lastValue = 0;
            doOperation();
        }
    };

    View.OnClickListener listenerResultPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doOperation();
            lastValue = 0;
            result = 0;
        }
    };

    private void doOperation() {
        Double nextNumber = Double.parseDouble(txtDisplay.getText().toString());
        switch (operation) {
            case PLUS:
                result = lastValue + nextNumber;
                break;
            case MINUS:
                result = lastValue - nextNumber;
                break;
            case TIMES:
                result = lastValue * nextNumber;
                break;
            case DIVISION:
                result = lastValue / nextNumber;
                break;
            default:
                break;
        }
        lastValue = 0;
        txtDisplay.setText(Double.toString(result));
    }

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
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCE = findViewById(R.id.btnCE);
        btnResult = findViewById(R.id.btnIgual);
        btnTimes = findViewById(R.id.btnMultiplicar);
        btnDivision = findViewById(R.id.btnDividir);
        btnPlus = findViewById(R.id.btnSomar);
        btnSubtract = findViewById(R.id.btnSubtrair);
    }

    View.OnClickListener listenerNumericPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button pressedButton = (Button) v;
            String pressedValue = pressedButton.getText().toString();
            String actualValue = getActualValue();
            String nextValue = actualValue + pressedValue;
            txtDisplay.setText(nextValue);
            lastValue = Double.parseDouble(nextValue);
        }
    };

    private String getActualValue() {
        String actualValue = txtDisplay.getText().toString();
        if (Double.parseDouble(actualValue) == 0) {
            actualValue = STRING_EMPTY;
        }
        return actualValue;
    }

    View.OnClickListener listenerOperationPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button botaoPressionado = (Button)v;
            txtDisplay.setText(STRING_EMPTY);
            operation = botaoPressionado.getText().toString();
        }
    };
}