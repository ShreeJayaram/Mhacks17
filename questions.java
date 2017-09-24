package com.example.prats.findmestats;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;






public class questions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final EditText income = (EditText) findViewById(R.id.monthly_income_edit_text);
        Button nextButton = (Button) findViewById(R.id.monthly_income_next_button);

        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Double incomeDouble = Double.parseDouble(income.getText().toString());
                Log.d("QuestionsActivity", incomeDouble.toString());
                Intent intent = new Intent(questions.this, question2.class);
                //intent.putExtra("ARG_MONTHLY_INCOME", incomeDouble);

                Bundle bundle = new Bundle();
                bundle.putDouble("ARG_MONTHLY_INCOME", incomeDouble);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
//        income.setHint("Monthly Income");

    }



}
