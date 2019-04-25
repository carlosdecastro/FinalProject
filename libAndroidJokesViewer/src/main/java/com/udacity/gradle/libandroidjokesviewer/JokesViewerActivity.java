package com.udacity.gradle.libandroidjokesviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokesViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_viewer);

        // Display de back button in the SupportActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView mJoke = findViewById(R.id.joke);

        Intent intent = getIntent();

        // If there is and intent, get his extras and update the textView
        if (intent != null) {
            String joke = intent.getStringExtra(getString(R.string.joke));
            mJoke.setText(joke);
        } else {
            mJoke.setText(getString(R.string.joke_error));
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // The listener for de back button, when is clicked then finish the activity to return to de main activity
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
