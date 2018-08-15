package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

public class JokeEndpointsAsyncTaskTest {

    String mJoke = null;
    CountDownLatch signal = null;

    @Before
    public void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @After
    public void tearDown() throws Exception {
        signal.countDown();
    }

    @Test
    public void testNonEmptyJokeRetrievedFromEndpointsAsyncTask() throws InterruptedException {

        JokeEndpointsAsyncTask jokeEndpointsAsyncTask = new JokeEndpointsAsyncTask();
        jokeEndpointsAsyncTask.setListener(new JokeEndpointsAsyncTask.JokeEndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String result) {
                mJoke = result;
                signal.countDown();
            }
        }).execute();
        signal.await();
        assertFalse(mJoke.startsWith("failed to connect to"));
        assertFalse(TextUtils.isEmpty(mJoke));
    }


}