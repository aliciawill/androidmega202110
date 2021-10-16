package com.mega.mobile04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button b1, b2, b3; //전역변수로 null로 자동 초기화


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "페이지2로 넘어갑니다. ",
                        Toast.LENGTH_SHORT).show();
                //화면 넘겨주는 객체생성해주어야 함.
                //생성자(현재액티비티, 넘어갈액티비티)
                Intent intent = new Intent(MainActivity2.this, Page2.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Start페이지를 종료합니다. ",
                        Toast.LENGTH_SHORT).show(); //체인식 코드
                finish();
            }
        });
    }
}