package com.example.twofragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


// This is the secondary fragment, displaying the details of a particular
// item.


public class DetailsFragment extends Fragment {

    private static final String TAG = "DetailsFRAGMENT";
    // Create a new instance of DetailsFragment, initialized to show the
    // text at 'index'.

    public static DetailsFragment newInstance(int index) {
        DetailsFragment detailsFragment = new DetailsFragment();

        // Supply index input as an argument.
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        detailsFragment.setArguments(bundle);

        return detailsFragment;
    }

    //region DetailsFragment LifeCycle
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, " onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, " onDetach()");
    }

    //endregion

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    // We create the UI with a scrollview and text and return a reference to
    // the scroller which is then drawn to the screen

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "DetailsFragment:onCreateView",
                Toast.LENGTH_LONG).show();

        // programmatically create a scrollview and texview for the text in
        // the container/fragment layout. Set up the properties and add the
        // view.

        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, getActivity()
                        .getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);

        scroller.addView(text);
        text.setText(Shakespeare.DIALOGUE[getShownIndex()]);
        return scroller;
    }
}
