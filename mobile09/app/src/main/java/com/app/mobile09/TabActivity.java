package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        LinearLayout layout1 = findViewById(R.id.tabSong);
        LinearLayout layout2 = findViewById(R.id.tabArtist);
        LinearLayout layout3 = findViewById(R.id.tabAlbum);

        View songView = (View)View.inflate(TabActivity.this, R.layout.song, null);
        View artView = (View)View.inflate(TabActivity.this, R.layout.art, null);
        View albumView = (View)View.inflate(TabActivity.this, R.layout.album, null);

        layout1.addView(songView);
        layout2.addView(artView);
        layout3.addView(albumView);

        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);

        ImageView songIV = songView.findViewById(R.id.imageView);
        Button button = songView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songIV.setImageResource(R.drawable.pici_icon);
            }
        });

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);


        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨별");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);


    }
}