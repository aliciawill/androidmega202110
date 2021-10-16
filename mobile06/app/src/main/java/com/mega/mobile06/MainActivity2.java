package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String[] hobby = intent.getStringArrayExtra("hobby");
        String list = "";
        for(String one: hobby){
            list += one + " ";
        }
        ArrayList<String> subject = intent.getStringArrayListExtra("subject");
        Log.d("확인", subject.toString());
        String name = intent.getStringExtra("name"); //"honggildong"
        int age = intent.getIntExtra("age", 0); //100
        double height = intent.getDoubleExtra("height", 0); //199.9
        Toast.makeText(getApplicationContext(),
                "받은 이름은 >> " + name + "\nhobby>> " + list + "\nsubject>> " + subject,
                Toast.LENGTH_SHORT
                ).show();
        Toast.makeText(getApplicationContext(),
                "받은 나이 >> " + age + "\nheight>> " + height,
                Toast.LENGTH_SHORT
        ).show();
    }
}