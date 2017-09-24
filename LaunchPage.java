package com.example.prats.findmestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LaunchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_page2);
    }



    public void LoginActivity(View view) {

        startActivity(new Intent(LaunchPage.this, LoginActivity.class));
    }
}
