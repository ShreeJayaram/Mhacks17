package com.example.prats.findmestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;

public class invest extends AppCompatActivity {

    public double[] riskValues = new double[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);




        final EditText percentage = (EditText) findViewById(R.id.invest_Edit_Text);
        Button nextButton = (Button) findViewById(R.id.invest_next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double available,net=0.00;

                Bundle bundle = getIntent().getExtras();
                available = bundle.getDouble("INVEST");

                Double percentageDouble = Double.parseDouble(percentage.getText().toString());
                Log.d("INVEST QUESTION", percentage.toString());
                Intent intent = new Intent(invest.this, result.class);
                intent.putExtra("INVEST PERCENTAGE", percentageDouble);
                //startActivity(intent);

                net = available*(percentageDouble/100);

                HackKingsAPIReader blackrockAPI = new HackKingsAPIReader();
                try {
                    String jsonString = blackrockAPI.readData("GOOG,AAPL,FB,CVS,WBA,IBM,MET,PEP,MSFT,NKE,T,F,HD,CVX,WMT,XOM,ORCL,COST,UPS,GS");
                    riskValues = getRiskFromJSON(jsonString);
                } catch (Exception e) {
                    // oops
                }

                String[] display = {"GOOG,AAPL,FB,CVS,WBA,IBM,MET,PEP,MSFT,NKE,T,F,HD,CVX,WMT,XOM,ORCL,COST,UPS,GS"};
                double temp=0.000;
                String temp2;
               for(int i= 0; i < 20; i++) {
                   for (int j = 1; j < 20; j++) {
                        if(riskValues[j-1]>riskValues[j]) {
                            temp=riskValues[j-1];
                            temp2=display[j-1];
                            riskValues[j-1]=riskValues[j];
                            display[j-1]=display[j];
                            riskValues[j]=temp;
                            display[j]=temp2;

                        }
                   }
               }

            }


        });
    }

    private double[] getRiskFromJSON(String jsonString) throws JSONException {
        JSONObject response = new JSONObject(jsonString);
        JSONObject resultMap = response.getJSONObject("resultMap");
        JSONArray returns = resultMap.getJSONArray("RETURNS");
        int lengthOfReturns = returns.length();
        double[] riskValues = new double[lengthOfReturns];

        for (int i = 0; i < lengthOfReturns; i++) {
            JSONObject stockReturn = returns.getJSONObject(i);
            JSONObject latestPerf = stockReturn.getJSONObject("latestPerf");
            double oneYearRisk = latestPerf.getDouble("oneYearRisk");
            riskValues[i] = oneYearRisk;
        }

        return riskValues;}


        public void result(View view) {

            startActivity(new Intent(invest.this, result.class));
        }




    }
