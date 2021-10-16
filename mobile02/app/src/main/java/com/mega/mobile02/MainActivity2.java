package com.mega.mobile02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText text3, text4;
    TextView result;
    Button b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text3 = findViewById(R.id.text3); //숫자1
        text4 = findViewById(R.id.text4); //숫자2
        result = findViewById(R.id.result); //결과를 보여주는 텍스트
        b3 = findViewById(R.id.b3); //위
        b4 = findViewById(R.id.b4); //더하기 버튼

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "나는 \n토스트!!!",
                        Toast.LENGTH_LONG
                        ).show();
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = text3.getText().toString();
                String n2 = text4.getText().toString();

                int i1 = Integer.parseInt(n1);
                int i2 = Integer.parseInt(n2);
                int sum = i1 + i2;
                result.setText("더한 결과값은 " + sum);
            }
        });

    }
}