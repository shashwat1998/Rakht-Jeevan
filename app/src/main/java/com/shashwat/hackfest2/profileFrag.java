package com.shashwat.hackfest2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Shashwat on 24-03-2018.
 */

public class profileFrag extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView  = inflater.inflate(R.layout.profile_frag, container, false);

        Button b1=(Button) myView.findViewById(R.id.but_view);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),view_contacts.class);
                startActivity(i);
            }
        });

        Button b2=(Button) myView.findViewById(R.id.but_add);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),add_contacts.class);
                startActivity(i);
            }
        });

        return myView;
    }

}
