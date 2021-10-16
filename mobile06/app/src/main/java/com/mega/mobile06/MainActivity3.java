package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity3 extends AppCompatActivity {
    EditText text1, text2;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = text1.getText().toString();
                String content = text2.getText().toString();
                //파일에 저장해보자.!
                Toast.makeText(getApplicationContext(),
                        "날짜는 " + date + " 내용은 " + content,
                        Toast.LENGTH_SHORT
                        ).show();
                try {
                    //FileOutputStream file = openFileOutput("new.txt", MODE_PRIVATE);
                    FileOutputStream file = openFileOutput("new" + date + ".txt", MODE_PRIVATE);
                    //String data = "i am a android programmer...";
                    String data = content;
                    file.write(data.getBytes());
                    file.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.d("", "파일이 존재하지 않습니다.");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("", "파일을 읽고 쓰는 중에 에러가 발생했습니다.");
                } catch (Exception e){
                    e.printStackTrace();
                    Log.d("", "에러가 발생했습니다.!!!");
                }
            }
        });
    }
}