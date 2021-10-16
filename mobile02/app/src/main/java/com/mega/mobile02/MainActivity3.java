package com.mega.mobile02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "네이버로 가자!", Toast.LENGTH_SHORT).show();
                //다른 화면으로 넘어가는 부품(객체)하나 만들었음.
                Intent intent =  new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://m.naver.com")
                        );
                startActivity(intent);
            } //onclick
        }); //button1

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "전화를 걸어요...!", Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:/01049142996")
                );
                startActivity(intent);
            } //onclick
        }); //button2

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "사진을 보러 갑시다..!", Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://media/internal/images/media")
                );
                startActivity(intent);
            } //onclick
        }); //button3

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "good bye!", Toast.LENGTH_SHORT).show();
                finish();
            } //onclick
        }); //button4

    }


}