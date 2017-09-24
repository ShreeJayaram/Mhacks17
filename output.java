package com.example.prats.findmestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);




        double income=0.00, premium=0.00, expenses=0.00, tax, available=0.00, consumption=0.00;

        Bundle bundle = getIntent().getExtras();
        income = bundle.getDouble("ARG_MONTHLY_INCOME");
        premium = bundle.getDouble("ARG_MONTHLY_PREMIUM");
        expenses = bundle.getDouble("ARG_MONTHLY_EXPENSES");



        consumption = premium + expenses;

        if (income <= 777)
            tax = income / 10;
        else if (income > 777 && income <= 3162)
            tax = income * (15 / 100);
        else if (income > 3162 && income <= 7658)
            tax = income * (25 / 100);
        else if (income > 7658 && income <= 15970)
            tax = income * (28 / 100);
        else if (income > 15970 && income <= 34725)
            tax = income * (33 / 100);
        else if (income > 34725 && income <= 34866)
            tax = income * (35 / 100);
        else
            tax = income * (39.60 / 100);

        available = income - consumption - tax;


        TextView textView = (TextView) findViewById(R.id.textView4_Text_View);
        TextView textView2 = (TextView) findViewById(R.id.textView4);
        textView.setText("Your tax is: " + Double.toString(tax));
        textView2.setText("Your Net Income is: " + Double.toString(available));

        Bundle bundle4 = new Bundle();
        Intent intent = new Intent(output.this, invest.class);
        bundle4.putDouble("AVAILABLE", available);
        intent.putExtras(bundle4);


    }



    public void invest(View view) {

        startActivity(new Intent(output.this, invest.class));
    }




}

