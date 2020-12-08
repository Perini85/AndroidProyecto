package com.example.sistema_academico2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class SeleccionarVideo extends AppCompatActivity {

    private static final int REQUEST_VIDEO_CAPTURE =100;
    private static final int REQUEST_PERMISSION_CAPTURE =101;

    Button btnRecordVideo, showVideo;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_video);

        btnRecordVideo = findViewById(R.id.btnRecordVideo);
        showVideo = findViewById(R.id.showVideo);

        btnRecordVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M){
              if(ActivityCompat.checkSelfPermission(SeleccionarVideo.this, Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
                  recordVideo();
              }else{
                  ActivityCompat.requestPermissions(SeleccionarVideo.this,new String[]{Manifest.permission.CAMERA},REQUEST_PERMISSION_CAPTURE);
              }

            }else{
                recordVideo();
            }
            }
        });


        showVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 gotoVideoActivity(uri.toString());
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode ==REQUEST_PERMISSION_CAPTURE){
            if(permissions.length >0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
               recordVideo();
            } else{
                Toast.makeText(this,"Necesitas permisos pata grabar video", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode ==REQUEST_VIDEO_CAPTURE){
            if(resultCode == Activity.RESULT_OK){
               uri = data.getData();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void recordVideo(){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT,30);
            startActivityForResult(intent,REQUEST_VIDEO_CAPTURE);
        }
    }

    private void  gotoVideoActivity(String uriString){
        Intent intent = new Intent(this, MostrarVideo.class);
        intent.putExtra("VIDEO",uriString);
        startActivity(intent);
    }
}