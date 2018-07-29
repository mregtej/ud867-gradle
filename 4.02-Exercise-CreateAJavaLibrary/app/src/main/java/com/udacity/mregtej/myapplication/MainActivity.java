package com.udacity.mregtej.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.udacity.mregtej.jokesmith.JokeSmith;
import com.udacity.mregtej.jokewizard.JokeWizard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView smithJoke = (TextView) findViewById(R.id.tv_smith_joke);
        JokeSmith jokeSmith = new JokeSmith();
        smithJoke.setText(jokeSmith.getJoke());

        TextView wizardJoke = (TextView) findViewById(R.id.tv_wizard_joke);
        JokeWizard jokeWizard = new JokeWizard();
        wizardJoke.setText(jokeWizard.getJoke());
    }
}
