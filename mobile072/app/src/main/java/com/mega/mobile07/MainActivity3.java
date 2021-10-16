package com.mega.mobile07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
Button confirm, siteGo;
EditText siteName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3); //인플레이션(증대)
        setTitle("i'm Activity3");
        //1. MainActivity에서 버튼을 누르면 다음 액티비티인 3번으로 넘겨야함.

        //2. 앞에서 입력한 데이터를 받아오세요.!
        Intent intent = getIntent();
        String tourName =  intent.getStringExtra("tourName");

        //3. 받아오자 마자 toast로 확인(toast함수를 만들어서 호출)
        toast(tourName);
        confirm = findViewById(R.id.confirm);
        siteGo = findViewById(R.id.siteGo);
        siteName = findViewById(R.id.siteName);


        //4. 받아온 데이터를 가지고,
        //   확인버튼을 누르면 대표적인 사이트로 연결!(goSite함수를 만들어서 호출)
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSite(tourName);
            }
        });
        //5. 입력란을 만들어서, 이동버튼을 누르면 해당 사이트로 연결!(goSite함수 호출)
        siteGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //입력값을 가지고 와서
                String tourName = siteName.getText().toString();
                //goSite()
                goSite(tourName);
            }
        });
        //6. goSite함수안에는 "넘어갑니다~~~"를 toast로 띄워져야 함.(toast함수를 호출)

    } //onCreate end
    public void toast(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    } //toast end

    public void goSite(String tourName){
        String site = "";
        if (tourName.equals("부산")){
            site = "https://www.busan.go.kr/open/index.jsp";
        }else if (tourName.equals("울산")){
            site = "https://www.ulsan.go.kr/u/emergency_main.jsp";
        }else {
            site = "https://www.pohang.go.kr/intro.html";
        }
        toast(site + "로 넘어갑니다~~~");
        Uri uri = Uri.parse(site); //묵시적(암시적) 인텐트
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}