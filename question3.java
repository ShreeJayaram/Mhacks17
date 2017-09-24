package com.example.prats.findmestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        final EditText expenses = (EditText) findViewById(R.id.question3_Edit_Text);
        Button nextButton = (Button) findViewById(R.id.question3_next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double income,premium;
                Bundle bundle = getIntent().getExtras();
                income = bundle.getDouble("ARG_MONTHLY_INCOME");
                premium = bundle.getDouble("ARG_MONTHLY_PREMIUM");

                Double expensesDouble = Double.parseDouble(expenses.getText().toString());
                Log.d("QuestionsActivity3", expenses.toString());
                Intent intent = new Intent(question3.this,output.class);
                //intent.putExtra("ARG_MONTHLY_EXPENSES", expensesDouble);
                Bundle bundle3 = new Bundle();
                bundle3.putDouble("ARG_MONTHLY_INCOME", income);
                bundle3.putDouble("ARG_MONTHLY_PREMIUM", premium);
                bundle3.putDouble("ARG_MONTHLY_EXPENSES", expensesDouble);
                intent.putExtras(bundle3);
                startActivity(intent);


            }


        });

    }





}
