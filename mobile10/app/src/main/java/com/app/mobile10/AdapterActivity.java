package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        setTitle("리스트뷰 테스트");

        //많은 양의 데이터를 view에 넣어주는 것을 adapter라고 부른다.
        //많은 양의 데이터: mid
        ArrayList<String> mid = new ArrayList<>();
        // jdk1.8에서 달라진 점?
        // 1)제너릭(generic, general) 프로그램
        //클래스를 만들 때 특정한 데이터 타입을 지정하지 않았다가, 객체를 생성할 때
        //특정한 데이터 타입을 지정해서 사용할 수 있는 프로그램
        mid.add("히어로즈");
        mid.add("24시");
        mid.add("로스트");
        mid.add("빅뱅이론");

        //view를 준비, listView
        ListView listView = findViewById(R.id.listView1);

        //adapter부품 필요
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mid);

        //listView에 adapter를 셋팅
        listView.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                mid.add(data);
                //어탭터를 리프레쉬
                adapter.notifyDataSetChanged();
            }
        }); //button end

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                String data = mid.get(index);
                Toast.makeText(getApplicationContext(), data + " " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}