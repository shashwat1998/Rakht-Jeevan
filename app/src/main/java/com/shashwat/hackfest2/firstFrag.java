package com.shashwat.hackfest2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Shashwat on 24-03-2018.
 */

public class firstFrag extends Fragment {


    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView  = inflater.inflate(R.layout.first_frag, container, false);
        return myView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView ew = (TextView) getView().findViewById(R.id.textView3);
        ew.setText(Html.fromHtml(getString(R.string.about)));
        // or  (ImageView) view.findViewById(R.id.foo);
    }
}
