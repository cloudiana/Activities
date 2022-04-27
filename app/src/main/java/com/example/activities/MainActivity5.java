package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity5 extends AppCompatActivity {
    //Initialize videoview
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //Set activity title
        getSupportActionBar().setTitle("<3");

        //Set location for the video to be inserted
        videoView = findViewById(R.id.videoview);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.vid;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);

        //Controls for the video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
    //Method override for the return button
    @Override
    public void finish() {
        super.finish();
        //Return animation
        overridePendingTransition(R.anim.slideleftin, R.anim.sliderightout);
    }
}