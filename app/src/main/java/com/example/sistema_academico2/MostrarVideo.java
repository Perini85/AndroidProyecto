package com.example.sistema_academico2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarVideo extends AppCompatActivity {
VideoView videoView;
Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_video);

        videoView = findViewById(R.id.videoView);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) uri = Uri.parse(bundle.getString("VIDEO"));


        videoView.setVideoURI(uri);
        videoView.start();
    }
}