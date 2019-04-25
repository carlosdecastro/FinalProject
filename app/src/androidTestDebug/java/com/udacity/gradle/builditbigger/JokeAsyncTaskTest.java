package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void testJokeAsyncTask() throws Throwable {

        JokeAsyncTask task = new JokeAsyncTask(new JokeAsyncTask.JokeRetrieveListener() {
            @Override
            public void onJokeRetrieveListener(String result) {

            }
        });

        try {
            task.execute(new Pair<Context, String>(mActivityRule.getActivity(), "ANIMALS"));
            String joke = task.get();

            assertNotNull(joke);
            assertFalse(joke.isEmpty());


        } catch (InterruptedException ie) {
            fail("Error");
        }
    }

}