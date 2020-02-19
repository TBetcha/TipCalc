package com.example.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private EditText mGetTip;
    private EditText mEnterTotal;
    private TextView mDisplayTotal;
    private Button mCalcButton;
    private Button mSubmitTip;
    private TextView mTotal;
    private Button mTotalEnter;
    public boolean hasTotal;




    private Bill billOne = new Bill();

    //TODO change to total -- double totalBill = Double.parseDouble(mGetTip.getText().toString());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGetTip = (EditText) findViewById(R.id.enter_tip);
        mTotal = (TextView) findViewById(R.id.total);
        mGetTip.setHint("Enter tip %");
        mEnterTotal = (EditText) findViewById(R.id.enter_total);
        mEnterTotal.setHint("Enter total");
        mSubmitTip = (Button) findViewById(R.id.submit_tip);
        mDisplayTotal = (TextView) findViewById(R.id.display_total);
        mTotalEnter = (Button) findViewById(R.id.total_enter);
        //TODO boolean hasTotal = false;




        mSubmitTip.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (mGetTip.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter tip %", Toast.LENGTH_SHORT).show();
                } else {
                    double tipPer = Double.parseDouble(mGetTip.getText().toString());
                    billOne.setTipAmt(tipPer);

                }
            }
        });


      mTotalEnter.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                {
                    double tot = Double.parseDouble(mEnterTotal.getText().toString());
                   mDisplayTotal.setText(valueOf(billOne.getTotal(tot, billOne.getTipAmt())+tot));



                }

            }

        });
    }


}

