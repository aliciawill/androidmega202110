package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class StarActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star2);

        TabHost tabHost = findViewById(R.id.tabhost2);
        tabHost.setup(); //기초적인 tab초기화!

        //각 탭마다의 설정을 넣음.
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG2").setIndicator("홈");
        tabSpecSong.setContent(R.id.tabSong2);//layout를 끼워넣음
        tabHost.addTab(tabSpecSong);

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST2").setIndicator("카테고리");
        tabSpecArtist.setContent(R.id.tabArtist2);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM2").setIndicator("선물함");
        tabSpecAlbum.setContent(R.id.tabAlbum2);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(1);

    }
}