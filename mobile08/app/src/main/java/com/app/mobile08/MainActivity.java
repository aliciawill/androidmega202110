package com.app.mobile08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView result;
    DatePicker datePicker;
    String timeTotal, dateTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("날짜, 시간 예약");
        chrono = findViewById(R.id.chronometer1);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        calView = findViewById(R.id.calendarView1);
        tPicker = findViewById(R.id.timePicker1);
        result = findViewById(R.id.result);
        //datePicker = findViewById(R.id.datePicker1);

        calView.setVisibility(View.INVISIBLE);
        //datePicker.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calView.setVisibility(View.VISIBLE);
                //datePicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calView.setVisibility(View.INVISIBLE);
                //datePicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                //크로노미터는 버튼을 눌렀을 때를 베이스로 해서 시작하게 해야한다.
                chrono.start();
                chrono.setTextColor(Color.BLUE);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.RED);
                int hour = tPicker.getCurrentHour();
                int min = tPicker.getCurrentMinute();
                timeTotal = hour + "시 " + min + "분";
                //toast("현재시각 " + timeTotal);
                result.setText(dateTotal + " " + timeTotal);
            }
        }); //btnEnd end

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView,
                                            int year, int month, int dayOfMonth) {
                dateTotal = year + "년 " + (month + 1) + "월 " + dayOfMonth + "일";
                toast("가지고 온 날짜는 " + dateTotal);
            }
        }); //calView end
    }//onCreate end

    public void toast(String text){
        Toast.makeText(getApplicationContext(),
                    text,
                    Toast.LENGTH_SHORT
                    ).show();
    }

} //class end