package com.mega.mobile04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {
    Button b4, b5, b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        b6 = findViewById(R.id.button6);

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "페이지2를 종료합니다. ",
                        Toast.LENGTH_SHORT).show(); //체인식 코드
                finish();
            }
        });

    }
}