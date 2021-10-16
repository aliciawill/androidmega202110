package com.mega.mobile02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    Button b1, b2;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //클릭했을 때 처리하고 싶은 내용을 여기에다가 쓰면 됨.
                Log.i("", "-------> b1을 클릭했음.");
                text1.setText("성공1!!!");
                String data = text2.getText().toString(); //입력한 값!!
                text1.setText(data);
            }
        }); //b1

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("", "-------> b2을 클릭했음.");
                text1.setText("성공2!!!");
            }
        });

    }
}