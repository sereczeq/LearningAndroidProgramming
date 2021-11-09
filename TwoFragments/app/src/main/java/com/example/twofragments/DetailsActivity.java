package com.example.twofragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

// This is a secondary activity, to show what the user has selected when the
// screen is not large enough to show it all in one activity.

public class DetailsActivity extends FragmentActivity {

    private static final String TAG = "DetailsACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, " onCreate()");

        Toast.makeText(this, "DetailsActivity", Toast.LENGTH_SHORT).show();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish();
            return;
        }

        if (savedInstanceState != null) return;
        // During initial setup, plug in the details fragment.

        // create fragment
        DetailsFragment details = new DetailsFragment();

        // get and set the position input by user (i.e., "index")
        // which is the construction arguments for this fragment
        details.setArguments(getIntent().getExtras());

        //
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, details)
                .commit();
    }

    //region DetailsActivity Lifecycle

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, " onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, " onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, " onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, " onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, " onRestart()");
    }
//endregion

}
