package com.udacity.mregtej.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.udacity.mregtej.jokesmith.JokeSmith;
import com.udacity.mregtej.mylibrary.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getJoke(View view) {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra("joke", new JokeSmith().getJoke());
        startActivity(intent);
    }
}
