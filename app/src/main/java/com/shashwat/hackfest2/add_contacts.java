package com.shashwat.hackfest2;

import android.media.MediaScannerConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class add_contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
    }
    public void onButton(View view){
        EditText et = (EditText) findViewById(R.id.editText);
        String text= et.getEditableText().toString();
        et.setText("");

        EditText et2 = (EditText) findViewById(R.id.editText2);
        String text2= et2.getEditableText().toString();
        et2.setText("");

        try {
            // Creates a file in the primary external storage space of the
            // current application.
            // If the file does not exists, it is created.

            File testFile = new File(this.getFilesDir(), "name.txt");
            File testFile2 = new File(this.getFilesDir(), "data.txt");
            if (!testFile.exists()) {
                testFile.createNewFile();
                testFile2.createNewFile();
            }

            // Adds a line to the file
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(testFile, true /*append*/)));
            PrintWriter writer2 = new PrintWriter( new BufferedWriter(new FileWriter(testFile2, true /*append*/)));
            writer.println(text);
            writer2.println(text2);
            writer.close();
            writer2.close();
            Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show();
            // Refresh the data so it can seen when the device is plugged in a
            // computer. You may have to unplug and replug the device to see the
            // latest changes. This is not necessary if the user should not modify
            // the files.
            MediaScannerConnection.scanFile(this,
                    new String[]{testFile.toString()},
                    null,
                    null);
        } catch (IOException e) {
            Log.e("ReadWriteFile", "Unable to write to the TestFile.txt file.");
        }
    }

    }

