package com.navinnayak.android.tourguideapp.fragments;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navinnayak.android.tourguideapp.R;
import com.navinnayak.android.tourguideapp.common.TGABaseFragment;

/**
 * A simple {@link TGABaseFragment} subclass.
 */
public class Home extends TGABaseFragment {
    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_screen, container, false);
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

    public interface OnFragmentInteractionListener {
        void onHomeInteraction(Uri uri);
    }
}