package com.udacity.mregtej.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView joke = (TextView) findViewById(R.id.tv_joke);
        Intent intent = getIntent();
        if(intent.hasExtra("joke")) {
            joke.setText(intent.getStringExtra("joke"));
        }
    }
}
