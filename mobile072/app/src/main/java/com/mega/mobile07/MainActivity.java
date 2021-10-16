package com.mega.mobile07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button goButton, resetButton;
    EditText tourName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.goButton);
        resetButton = findViewById(R.id.resetButton);
        tourName = findViewById(R.id.tourName);

        goButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }//onCreate() end

    @Override
    public void onClick(View view) {
        String who = "";
        if (view.getId() == R.id.goButton) { //버튼 구분!
            who = "goButton";
        }else{
            who = "resetButton";
        }

        String data = tourName.getText().toString();
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("tourName", data);
        intent.putExtra("who", who);
        startActivity(intent);

    } //onClick() end

}