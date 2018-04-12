package com.shashwat.hackfest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class bleed_minor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleed_minor);
        TextView ew = (TextView)findViewById(R.id.textView2);
        ew.setText(Html.fromHtml(getString(R.string.minor)));
    }
}
