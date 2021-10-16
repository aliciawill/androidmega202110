package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;                 //a()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //부모클래스의 있는 메서드를 호출할때 super이용!
        //액티비티의 기본틀설정, 제목넣고, 기본색 설정
        setContentView(R.layout.activity_main);
        //a();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //액티비티를 넘기려고 함.
                //넘기는 데이터를 함께 보내려고 한다.
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", "honggildong");
                intent.putExtra("age", 100);
                intent.putExtra("height", 199.9);
                String[] hobby = {"놀기", "자기", "또놀기"};
                ArrayList<String> subject = new ArrayList<>();
                subject.add("컴퓨터");
                subject.add("영어");
                subject.add("수학");
                subject.add("스포츠");
                intent.putExtra("hobby", hobby);
                intent.putExtra("subject", subject);
                startActivity(intent);
            }
        });
    }
}