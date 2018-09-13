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

public class Malls extends TGABaseFragment {
    private OnFragmentInteractionListener mListener;

    public Malls() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.mall_name_1), getString(R.string.mall_description_1), getString(R.string.mall_address_1), getString(R.string.mall_phone_1), getString(R.string.mall_opening_hours_1), R.drawable.ub_city_mall));
        locations.add(new Location(getString(R.string.mall_name_2), getString(R.string.mall_description_2), getString(R.string.mall_address_2), getString(R.string.mall_phone_2), getString(R.string.mall_opening_hours_2), R.drawable.one_mg_road));
        locations.add(new Location(getString(R.string.mall_name_3), getString(R.string.mall_description_3), getString(R.string.mall_address_3), getString(R.string.mall_phone_3), getString(R.string.mall_opening_hours_3), R.drawable.vr_bengaluru));
        locations.add(new Location(getString(R.string.mall_name_4), getString(R.string.mall_description_4), getString(R.string.mall_address_4), getString(R.string.mall_phone_4), getString(R.string.mall_opening_hours_4), R.drawable.orion_mall));

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
        mListener = (Malls.OnFragmentInteractionListener) context;
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
        void onMallsInteraction(Uri uri);
    }
}