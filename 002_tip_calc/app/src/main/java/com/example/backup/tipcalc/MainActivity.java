package com.example.backup.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    EditText realBill;
    EditText realTip;
    TextView tip;
    TextView Billpt;
    TextView text;
    Double bill;
    DecimalFormat df = new DecimalFormat("###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        Billpt = (TextView) findViewById(R.id.fldBpt);
        tip = (TextView) findViewById(R.id.fldTip);
        text = (TextView) findViewById(R.id.fldBill);
        realBill = (EditText) findViewById(R.id.fldNumber);
        realTip = (EditText) findViewById(R.id.fldTipnumber);
        Random random = new Random();
        bill = 1 + random.nextDouble() * (100 - 5);
        String billStr = ("$" + df.format(bill));
        text.setText(billStr);
    }



    public void OnClick(View view)
    {
        Double rb = Double.valueOf(realBill.getText().toString());
        Double rt = Double.valueOf(realTip.getText().toString());
        rt = rt * .01;
        String Tip = ("$" + df.format((rb * rt)));
        tip.setText(Tip);
        String bpt = ("$" + df.format((rb * rt) + rb));
        Billpt.setText(bpt);
    }

    public void OnClick10(View view)
    {
        Double rb = Double.valueOf(realBill.getText().toString());
        Double rt = Double.valueOf(realTip.getText().toString());
        String tenTip = ("$" + df.format((rb * .1)));
        tip.setText(tenTip);
        String bpt = ("$" + df.format((rb * .1) + rb));
        Billpt.setText(bpt);
    }
    public void OnClick15(View view)
    {
        Double rb = Double.valueOf(realBill.getText().toString());
        String fftenTip = ("$" + df.format((rb * .15)));
        tip.setText(fftenTip);
        String bpt = ("$" + df.format((rb * .15) + rb));
        Billpt.setText(bpt);
    }
    public void OnClick20(View view)
    {
        Double rb = Double.valueOf(realBill.getText().toString());
        String twenTip = ("$" + df.format((rb * .20)));
        tip.setText(twenTip);
        String bpt = ("$" + df.format((rb * .20) + rb));
        Billpt.setText(bpt);

    }
}
