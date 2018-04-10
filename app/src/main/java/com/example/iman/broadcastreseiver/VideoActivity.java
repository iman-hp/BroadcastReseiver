package com.example.iman.broadcastreseiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    VideoView videoview;
    String videoURL = "https://hw14.asset.aparat.com/aparat-video/c9d6baf619d0ddf95e119f55a09d08257958536-480p__33462.mp4";
    BroadcastReceiver callReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        videoview = findViewById(R.id.videoview);


        videoview.setMediaController(new MediaController(this));
        videoview.setVideoURI(Uri.parse(videoURL));
        videoview.start();
        callReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
              if(videoview.isPlaying())
                  videoview.pause();
            }
        };

        IntentFilter callFilter=new IntentFilter("android.intent.action.PHONE_STATE");
        registerReceiver(callReceiver   ,callFilter);



    }
    @Override
    protected void onDestroy() {
        unregisterReceiver(callReceiver);
        super.onDestroy();
    }

}
