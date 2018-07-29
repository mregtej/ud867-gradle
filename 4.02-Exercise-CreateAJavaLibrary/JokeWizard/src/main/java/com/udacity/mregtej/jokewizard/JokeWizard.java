package com.udacity.mregtej.jokewizard;

import com.udacity.mregtej.jokesmith.JokeSmith;

public class JokeWizard {
    public String getJoke() {
        return "That's a Wizard's Joke + " + new JokeSmith().getJoke();
    }
}
