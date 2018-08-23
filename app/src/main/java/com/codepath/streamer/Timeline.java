package com.codepath.streamer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class Timeline extends AppCompatActivity {
    private ArrayList<Music> musicList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        onRequestAPI();

    }

    private void onRequestAPI(){
       /* ArrayList<Music> music = Music.getFakeMusic();
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        MusicAdapter adapter = new MusicAdapter(Timeline.this, music);*/

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        musicList = Music.getFakeMusic();
        MusicAdapter adapter = new MusicAdapter(this, musicList, new MusicAdapter.RecyclerItemClickListener() {
            @Override
            public void onClickListener(Music music, int position) {
                Toast.makeText(Timeline.this, music.getTitre(), Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //recycler.setAdapter(adapter);
    }

    private void initializeViews(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
    }
}
