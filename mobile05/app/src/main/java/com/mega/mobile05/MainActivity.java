package com.mega.mobile05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3; //전역변수, 글로벌변수, 자동초기화 null로 초기화!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                String[] masjib = new String[]{"원조두꺼비집불오징어", "연희동칼국수", "horizon16"};
                dlg.setItems(masjib, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("", "선택한 인덱스 " + i + "는, " + masjib[i] + "이지요~");
                        String pre = "https://www.google.com/search?q=";
                        String mid = "&newwindow=1&tbm=lcl&sxsrf=AOaemvJZhS9mgB67RJI7T6SXVVr0iUPpzg%3A1632904652751&ei=zCVUYZycLcOzmAWYv6C4Ag&oq=";
                        String site = pre + masjib[i] + mid + masjib[i];
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
                        startActivity(intent);
                    }
                });
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                        String[] masjib = new String[]{"원조두꺼비집불오징어", "연희동칼국수", "horizon16"};
                        dlg.setTitle("menu");
                        dlg.setItems(masjib, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.d("", "선택한 인덱스 " + i + "는, " + masjib[i] + "이지요~");
                                String pre = "https://www.google.com/search?q=";
                                String mid = "&newwindow=1&tbm=lcl&sxsrf=AOaemvJZhS9mgB67RJI7T6SXVVr0iUPpzg%3A1632904652751&ei=zCVUYZycLcOzmAWYv6C4Ag&oq=";
                                String site = pre + masjib[i] + mid + masjib[i];
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
                                startActivity(intent);
                            }
                        });
                        dlg.show();
                    }
                });


                button3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                intent.putExtra("name", "kim");
                                intent.putExtra("age", 100);
                                startActivity(intent);
                            }
                        });
                    }//onCreate
                }//class
