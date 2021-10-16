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
                Log.d("sqlite3DML", "데이터베이스 생성 호출함……—");
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
                Log.d("sqlite3DML", "데이터베이스 삭제 호출함……—");
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
                Log.d("sqlite3DML", "데이터베이스 수정 호출함……—");
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
                    //cursor.moveToNext() 첫번째 행을 가르키면서 있는지 없는지 체크
                    //있으면 true리턴
                    //각 열에 있는 값들을 인덱스로 꺼내오면 됨.
                    //인덱스는 0부터 시작!
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