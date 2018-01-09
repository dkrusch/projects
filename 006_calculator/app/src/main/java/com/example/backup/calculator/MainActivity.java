package com.example.backup.calculator;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtResult;
    private EditText txtInput;
    private TextView displayOperation;

    private Double operand1 = null;
    private Double operand2 = null;
    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        txtInput = findViewById(R.id.txtInput);
        displayOperation = findViewById(R.id.txtSign);

        Button button0 = findViewById(R.id.btn0);
        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);
        Button button3 = findViewById(R.id.btn3);
        Button button4 = findViewById(R.id.btn4);
        Button button5 = findViewById(R.id.btn5);
        Button button6 = findViewById(R.id.btn6);
        Button button7 = findViewById(R.id.btn7);
        Button button8 = findViewById(R.id.btn8);
        Button button9 = findViewById(R.id.btn9);
        Button buttonDot = findViewById(R.id.btnPeriod);

        Button buttonEql = findViewById(R.id.btnEqu);
        Button buttonPlus = findViewById(R.id.btnPlus);
        Button buttonMinus = findViewById(R.id.btnMin);
        Button buttonDiv = findViewById(R.id.btnDiv);
        Button buttonMult = findViewById(R.id.btnTimes);
        Button buttonSqr = findViewById(R.id.btnSqr);
        Button buttonNeg = findViewById(R.id.btnNEG);

        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Button b = (Button) view;
                txtInput.append(b.getText().toString());
            }
        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        View.OnClickListener operations = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Button o = (Button) view;
                String op = o.getText().toString();
                String value = txtInput.getText().toString();
                if (value.length() != 0)
                {
                    performOperation(value, op);
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };

        buttonEql.setOnClickListener(operations);
        buttonPlus.setOnClickListener(operations);
        buttonMinus.setOnClickListener(operations);
        buttonDiv.setOnClickListener(operations);
        buttonMult.setOnClickListener(operations);
        buttonSqr.setOnClickListener(operations);

        View.OnClickListener neg = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String val = txtInput.getText().toString();
                if (val.length() == 0)
                {
                    txtInput.setText("-");
                }
                else
                {
                    try
                    {
                        Double dub = Double.parseDouble(val);
                        dub *= -1;
                        txtInput.setText(dub.toString());
                    }
                    catch (NumberFormatException e)
                    {
                        //Either "-" or ".", set to nothing
                        txtInput.setText("");
                    }
                }

            }
        };

        buttonNeg.setOnClickListener(neg);
    }

    public void performOperation(String value, String op)
    {
        displayOperation.setText(op);

        if (operand1 == null)
        {
            operand1 = Double.valueOf(value);
            if (op.equals("√"))
            {
                if (operand2 < 0)
                {
                    operand1 = 0.0;
                }
                else
                {
                    operand1 = Math.sqrt(operand1);
                }
            }
        }
        else
        {
            operand2 = Double.valueOf(value);
            if (pendingOperation.equals("="))
            {
                pendingOperation = op;
            }
            switch (pendingOperation)
            {
                case "=":
                    operand1 = operand2;
                    break;
                case "+":
                    operand1 += operand2;
                    break;
                case "-":
                    operand1 -= operand2;
                    break;
                case "/":
                    if (operand2 == 0)
                    {
                        operand1 = 0.0;
                    }
                    else
                    {
                        operand1 /= operand2;
                    }
                    break;
                case "*":
                    operand1 *= operand2;
                    break;
                case "√":
                    if (operand2 < 0)
                    {
                        operand1 = 0.0;
                    }
                    else
                    {
                        operand1 = Math.sqrt(operand2);
                    }
            }
        }

        txtResult.setText(operand1.toString());
        txtInput.setText("");

    }

}


