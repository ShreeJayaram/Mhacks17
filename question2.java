package com.example.prats.findmestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);


        final EditText premium = (EditText) findViewById(R.id.question2_Edit_Text);
        Button nextButton = (Button) findViewById(R.id.question2_next_button);

        double income = 0.00;

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double income;
                Bundle bundle = getIntent().getExtras();
                income = bundle.getDouble("ARG_MONTHLY_INCOME");


                Double premiumDouble = Double.parseDouble(premium.getText().toString());
                Log.d("QuestionsActivity2", premium.toString());
                Intent intent = new Intent(question2.this, question3.class);
                //intent.putExtra("ARG_MONTHLY_PREMIUM", premiumDouble);
                Bundle bundle2 = new Bundle();
                bundle2.putDouble("ARG_MONTHLY_PREMIUM", premiumDouble);
                bundle2.putDouble("ARG_MONTHLY_INCOME", income);
                intent.putExtras(bundle2);
                startActivity(intent);


            }


        });
    }

}

