package com.example.tipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.icu.util.Currency;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;


public class MainActivity extends AppCompatActivity {

    private EditText mGetTip;
    private EditText mEnterTotal;
    private TextView mDisplayTotal;
    private Button mCalcButton;
    private Button mSubmitTip;
    private TextView mTotal;
    private Button mTotalEnter;
    private CheckBox personable;
    private CheckBox fastService;
    public boolean hasTotal = false;
    public boolean personableChecked = false;
    public boolean fastServiceChecked = false;


    private Bill billOne = new Bill();

    //TODO make some sort of begin function which holds all the booleans so it's not so scattered.



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
        personable = (CheckBox) findViewById(R.id.personable);
        fastService = (CheckBox) findViewById(R.id.fast_service);



        //this will make checkboxes invisible before computing total
        if(mDisplayTotal.getText().toString().isEmpty()) {
            personable.setVisibility(View.INVISIBLE);
            fastService.setVisibility(View.INVISIBLE);
        }

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
                   mDisplayTotal.setText(valueOf(billOne.getTotal(billOne.getTipAmt(), tot)));
                    hasTotal = true;
                    if(hasTotal == true){
                        mTotalEnter.setClickable(false);
                        mSubmitTip.setClickable(false);
                    }else if(hasTotal == false){
                        personable.setClickable(false);
                        fastService.setClickable(false);
                    }
                    //once we generate a total checkboxes will be made
                    if(!mDisplayTotal.getText().toString().isEmpty()){
                        personable.setVisibility(View.VISIBLE);
                        fastService.setVisibility(View.VISIBLE);
                    }
                }
            }

        });

        //TODO stop incrementing total after one click & check boxes dont work if clicked before total
        // so make them invisible until after a total has been calculated.

        personable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(billOne.getTipAmt() == 0){
                    return;
                }
                if(personable.isChecked()){
                    double total = (Double.parseDouble(mDisplayTotal.getText().toString()));
                   double newWithExtra =  (total *.01) + total;
                   mDisplayTotal.setText(valueOf(newWithExtra));
                   personableChecked = true;
                }

            }
        });

        fastService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(billOne.getTipAmt() == 0){
                    return;
                }
                if(fastService.isChecked()){
                    double total = (Double.parseDouble(mDisplayTotal.getText().toString()));
                   double newWithExtra =  (total *.01) + total;
                   mDisplayTotal.setText(valueOf(newWithExtra));
                   fastServiceChecked = true;
                }
            }
        });



    }

}

