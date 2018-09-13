package com.navinnayak.android.tourguideapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.navinnayak.android.tourguideapp.Location;
import com.navinnayak.android.tourguideapp.LocationAdapter;
import com.navinnayak.android.tourguideapp.R;
import com.navinnayak.android.tourguideapp.common.TGABaseFragment;

import java.util.ArrayList;

public class Historical extends TGABaseFragment {
    private OnFragmentInteractionListener mListener;

    public Historical() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.historical_name_1), getString(R.string.historical_description_1), R.drawable.halasuru_someshwara_temple));
        locations.add(new Location(getString(R.string.historical_name_2), getString(R.string.historical_description_2), R.drawable.bangalore_palace));
        locations.add(new Location(getString(R.string.historical_name_3), getString(R.string.historical_description_3), R.drawable.iskcon_temple));
        locations.add(new Location(getString(R.string.historical_name_4), getString(R.string.historical_description_4), R.drawable.vidhana_soudha));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list.xml file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteractionListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {
        void onHistoricalInteraction(Uri uri);
    }
}