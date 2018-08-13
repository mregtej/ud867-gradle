package com.udacity.mregtej.jokemaker;

import java.util.ArrayList;
import java.util.Random;

public class JokeMaker {

    static ArrayList<String> jokes = new ArrayList<String>() {{
        add("This is a funny joke!");
        add("Another funny joke comes!");
        add("Did you ask a joke?");
        add("Don't forget your joke!");
        add("Don't you deserve a new joke?");
        add("Best joke ever!!");
    }};

    public JokeMaker() {

    }


    public static String makeAJoke() {
        Random random = new Random();
        int n = random.nextInt(jokes.size());
        return jokes.get(n);
    }

}
