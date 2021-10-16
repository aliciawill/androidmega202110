package com.mega.mobile04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Page3 extends AppCompatActivity {
    Button b7, b8, b9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        b9 = findViewById(R.id.button9);

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "페이지3를 종료합니다. ",
                        Toast.LENGTH_SHORT).show(); //체인식 코드
                finish();
            }
        });
    }
}