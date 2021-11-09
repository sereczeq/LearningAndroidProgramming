/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// This code has some modifications to the original 
// See http://developer.android.com/guide/components/fragments.html
// for a detailed discussion on the app
// I don't recommend toast as debug for flow but why not do that to get started.
// Better to use Log.d() which we introduced before. Toast is fleeting and logs 
// will always in in the LogCat -- hence they are more useful and better practice;
// but you can't see them on the phone. It is sort cool to see onCreate() toast
// as you flip the phone's orientation. It reinforces the lifecycle and the 
// automatic adjustment of the UI.
//
// ATC 2013

package com.example.twofragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;


// Demonstration of using fragments to implement different activity layouts.
// This sample provides a different layout (and activity flow) when run in
// landscape.

public class FragmentLayout extends FragmentActivity {

    private static final String TAG = "FragmentLayoutACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, " onCreate()");

        Toast.makeText(this, "FragmentLayout: OnCreate()", Toast.LENGTH_SHORT)
                .show();

        // Sets the view. Depending on orientation it will select either
        // res/layout/fragment_layout.xml (portrait mode) or
        // res/layout-land/fragment_layout.xml (landscape mode). This is done
        // automatically by the system.
        setContentView(R.layout.fragment_layout);
    }

    //region Lifecycle
    // FragmentLayout activity's Lifecycle
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
