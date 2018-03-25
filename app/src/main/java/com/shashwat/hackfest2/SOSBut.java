package com.shashwat.hackfest2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SOSBut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosbut);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)

        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
            }
        }
        else{

        }


        //rest
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Blood_groups, android.R.layout.simple_dropdown_item_1line);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
/*Intent i;
        i = new Intent(this, sosbutton.class);
        startActivity(i);*/

        public void onClick(View view) throws IOException {
            Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
            String text = mySpinner.getSelectedItem().toString();

                File testFile = new File(this.getFilesDir(), "name.txt");
                File testFile2 = new File(this.getFilesDir(), "data.txt");
                if (testFile == null && testFile2==null) {
                    testFile.createNewFile();
                    testFile2.createNewFile();
                }

                // Reads the data from the file
                BufferedReader reader1 = null;
                BufferedReader reader2 = null;
                try {
                    reader1 = new BufferedReader(new FileReader(testFile));
                    reader2 = new BufferedReader(new FileReader(testFile2));

                    String line1,line2;
                    String sms="Hey I urgently need blood of blood group "+text+".Please contact me as soon as possible.";
                SmsManager smsManager = SmsManager.getDefault();
                    while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null ) {
                        smsManager.sendTextMessage(line2, null, sms, null, null);
                    }
                Toast.makeText(this, "Message sent to emergency contacts. Redirecting to location of nearby hospitals", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, "Failed to send messages.  Redirecting to location of nearby hospitals", Toast.LENGTH_LONG).show();
            }
                reader1.close();
                reader2.close();;
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=hospitals+near+my+location"));
            startActivity(browserIntent);

        }



    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)

                    {
                        Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "No permission granted!", Toast.LENGTH_SHORT).show();
                    }
                    return;


                }

            }
        }

    }
}
