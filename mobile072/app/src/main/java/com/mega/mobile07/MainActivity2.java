package com.mega.mobile07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button find, next3;
    EditText data;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String tourName = intent.getStringExtra("tourName");
        String who = intent.getStringExtra("who");

//        Toast.makeText(getApplicationContext(), "받은 여행지는 " + tourName + " 누구?" + who , Toast.LENGTH_SHORT).show();
        String text = "받은 여행지는 " + tourName + " 누구? " + who;
        toast(text);

        find = findViewById(R.id.find);
        next3 = findViewById(R.id.next3);
        data = findViewById(R.id.data);
        imageView = findViewById(R.id.imageView);

        select(tourName);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tourName = data.getText().toString();
                select(tourName);
            }
        });
//        String name = "";
//        if (tourName.equals("부산")){
//            name = "pusan.jpg";
//            imageView.setImageResource(R.drawable.pusan);
//        } else if(tourName.equals("울산")){
//            name = "ulsan.jpg";
//            imageView.setImageResource(R.drawable.ulsan);
//        } else {
//            name = "pohang.jpg";
//            imageView.setImageResource(R.drawable.pohang);
//        }
////        Toast.makeText(getApplicationContext(),
////                "이미지 파일이름은 " + name,
////                Toast.LENGTH_SHORT).show();
//        toast(name);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //다음 액티비티인 3번으로 넘어가는 처리, 명시적 인텐트
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                String tourName = data.getText().toString();
                intent.putExtra("tourName", tourName);
                startActivity(intent);
            }
        });
    } //onCreate end

    //반복적인 처리 및 동작(함수, 메서드)
    public void toast(String name){
        Toast.makeText(getApplicationContext(),
                "확인값>> " + name,
                Toast.LENGTH_SHORT).show();
    } //toast end

    public void select(String tourName){
        String name = "";
        if (tourName.equals("부산")){
            name = "pusan.jpg";
            imageView.setImageResource(R.drawable.pusan);
        } else if(tourName.equals("울산")){
            name = "ulsan.jpg";
            imageView.setImageResource(R.drawable.ulsan);
        } else {
            name = "pohang.jpg";
            imageView.setImageResource(R.drawable.pohang);
        }
//        Toast.makeText(getApplicationContext(),
//                "이미지 파일이름은 " + name,
//                Toast.LENGTH_SHORT).show();
        toast(name);
    } //select end

}