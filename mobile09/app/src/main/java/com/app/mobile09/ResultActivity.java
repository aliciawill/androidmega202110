package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("명화 선호도 투표 결과");
        Intent intent = getIntent();
        String[] imgName = intent.getStringArrayExtra("imgName");
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        Toast.makeText(getApplicationContext(), imgName.length + ", " + voteCount.length,
                Toast.LENGTH_SHORT).show();

        TextView[] tv = new TextView[imgName.length];
        RatingBar[] rbar = new RatingBar[imgName.length];
        int[] tvID = {
                R.id.tv1,
                R.id.tv2,
                R.id.tv3,
                R.id.tv4,
                R.id.tv5,
                R.id.tv6,
                R.id.tv7,
                R.id.tv8,
                R.id.tv9
        }; //findViewById(id들)반복문!
        int[] rbatID = {
                R.id.rbat1,
                R.id.rbat2,
                R.id.rbat3,
                R.id.rbat4,
                R.id.rbat5,
                R.id.rbat6,
                R.id.rbat7,
                R.id.rbat8,
                R.id.rbat9
        };

        //TextView tv1  = findViewById(R.id.tv1);
        for (int i=0; i < imgName.length; i++){
            tv[i] = findViewById(tvID[i]);
            rbar[i] = findViewById(rbatID[i]);
        }

        for (int i=0; i < imgName.length; i++){
            tv[i].setText(imgName[i]);
            rbar[i].setRating(voteCount[i]);
        }
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}