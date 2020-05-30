package com.shashwat.rakhtjeevan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class bleed_wrist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleed_wrist);
        TextView ew = (TextView)findViewById(R.id.textView8);
        ew.setText(Html.fromHtml(getString(R.string.wrist)));
    }
}
