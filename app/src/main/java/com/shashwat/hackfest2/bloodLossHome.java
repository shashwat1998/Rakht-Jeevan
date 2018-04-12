package com.shashwat.hackfest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class bloodLossHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_loss_home);



    }

    public void onClickMenstrual(View view){
        Intent i=new Intent(this,bleed_mestrual.class);
        startActivity(i);

    }
    public void onClickHead(View view){
        Intent i=new Intent(this,bleed_head.class);
        startActivity(i);

    }
    public void onClickSlit(View view){
        Intent i=new Intent(this,bleed_wrist.class);
        startActivity(i);

    }
    public void onClickEars(View view){
        Intent i=new Intent(this,bleed_ears.class);
        startActivity(i);

    }
    public void onClickWounds(View view){
        Intent i=new Intent(this,bleed_wounds.class);
        startActivity(i);
    }
    public void onClickNose(View view){
        Intent i=new Intent(this,bleed_nose.class);
        startActivity(i);
    }
    public void onClickGums(View view){
        Intent i=new Intent(this,bleed_gums.class);
        startActivity(i);
    }
    public void onClickFinger(View view){
        Intent i=new Intent(this,bleed_rip.class);
        startActivity(i);
    }
    public void onClickMinor(View view){
        Intent i=new Intent(this,bleed_minor.class);
        startActivity(i);
    }

}
