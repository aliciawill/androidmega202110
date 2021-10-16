package com.mega.mobile05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age",0);
        Toast.makeText(getApplicationContext(),
                name + " " + age, Toast.LENGTH_LONG).show();

        try {
            FileOutputStream outputStream = openFileOutput("title" + ".txt", Context.MODE_PRIVATE);
            String total = "title" + "\n" + "content";
            outputStream.write(total.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
