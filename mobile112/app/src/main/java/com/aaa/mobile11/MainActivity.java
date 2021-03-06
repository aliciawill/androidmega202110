package com.aaa.mobile11;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.DriverManager;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    ListView edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect, btnDelete, btnUpdate;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);
        edtNameResult =  findViewById(R.id.edtNameResult);
        edtNumberResult =  findViewById(R.id.edtNumberResult);

        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect =  findViewById(R.id.btnSelect);
        btnDelete =  findViewById(R.id.btnDelete);
        btnUpdate =  findViewById(R.id.btnUpdate);

        myDBHelper = new MyDBHelper(this);


        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                myDBHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();
                String sql = "insert into groupTBL2 values ('" + name + "', '" + number + "');";
                sqlDB.execSQL(sql);
                Log.d("sqlite3DML", "?????????????????? ?????? ??????????????????");
                sqlDB.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String sql = "delete from groupTBL2 where gName ='" + name +"';";
                sqlDB.execSQL(sql);
                Log.d("sqlite3DML", "?????????????????? ?????? ??????????????????");
                sqlDB.close();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();
                String sql = "update groupTBL2 set gNumber = " + number + " where gName ='" + name +"';";
                sqlDB.execSQL(sql);
                Log.d("sqlite3DML", "?????????????????? ?????? ??????????????????");
                sqlDB.close();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dml => SQLiteDatabase
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                //String name = edtName.getText().toString();
                //String sql = "select * from groupTBL2 where gname = '" + name + "'";
                //select * from groupTBL2 where gname = 'a'
                String sql = "select * from groupTBL2";
                Cursor cursor = sqlDB.rawQuery(sql, null);

                String result2 = "";
                ArrayList<String> nameList = new ArrayList<>();
                ArrayList<Integer> numberList = new ArrayList<>();

                while (cursor.moveToNext()){
                    //cursor.moveToNext() ????????? ?????? ??????????????? ????????? ????????? ??????
                    //????????? true??????
                    //??? ?????? ?????? ????????? ???????????? ???????????? ???.
                    //???????????? 0?????? ??????!
                    //String result = cursor.getString(0) + ": " + cursor.getString(1);
                    //Log.d("sqlite3DML", result);
                    //result2 += result + " ";

                    nameList.add(cursor.getString(0));
                    numberList.add(cursor.getInt(1));
                }

                //Log.d("sqlite3DML", result2);
                Log.d("sqlite3DML", nameList.toString());
                Log.d("sqlite3DML", numberList.toString());

                cursor.close();
                sqlDB.close();






                ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, nameList);
                ArrayAdapter<Integer> numberAdapter = new ArrayAdapter<Integer>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, numberList);
                edtNameResult.setAdapter(nameAdapter);
                edtNumberResult.setAdapter(numberAdapter);
            }
        });

    }
}