package com.example.twofragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;


// This is the "top-level" fragment, showing a list of items that the user
// can pick. Upon picking an item, it takes care of displaying the data to
// the user as appropriate based on the current UI layout.

// Displays a list of items that are managed by an adapter similar to
// ListActivity. It provides several methods for managing a list view, such
// as the onListItemClick() callback to handle click events.


public class TitlesFragment extends ListFragment {
    private static final String TAG = "TitlesFRAGMENT";
    boolean mDualPane;
    int mCurCheckPosition = 0;

    // onActivityCreated() is called when the activity's onCreate() method
    // has returned.

    //region TitlesFragment's Lifecycle

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
    }

//        		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//			Log.d(TAG, "onCreateView()");
//
//		}


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


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, "onActivityCreated()");

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                Shakespeare.TITLES));

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = detailsFrame != null
                && detailsFrame.getVisibility() == View.VISIBLE;


        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setItemChecked(mCurCheckPosition, true);

        if (!mDualPane) return;
        // In dual-pane mode, the list view highlights the selected item.
        showDetails(mCurCheckPosition);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    // Helper function to show the details of a selected item, either by
    // displaying a fragment in-place in the current UI, or starting a whole
    // new activity in which it is displayed.

    void showDetails(int index) {
        mCurCheckPosition = index;

        if (!mDualPane) {

            // Create an intent for starting the DetailsActivity
            Intent intent = new Intent();

            // explicitly set the activity context and class
            // associated with the intent (context, class)
            intent.setClass(getActivity(), DetailsActivity.class);

            // pass the current position
            intent.putExtra("index", index);

            startActivity(intent);
            return;
        }

        getListView().setItemChecked(index, true);

        // Check what fragment is currently shown, replace if needed.
        DetailsFragment details = (DetailsFragment) getFragmentManager()
                .findFragmentById(R.id.details);

        if (details != null && details.getShownIndex() == index) return;

        details = DetailsFragment.newInstance(index);

        Toast.makeText(getActivity(),
                "showDetails dual-pane: create and replace fragment",
                Toast.LENGTH_LONG).show();

        // Execute a transaction, replacing any existing fragment
        // with this one inside the frame.
        getParentFragmentManager().beginTransaction()
                .replace(R.id.details, details)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

    }
}
