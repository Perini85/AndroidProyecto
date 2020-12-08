package com.example.sistema_academico2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Telefono extends AppCompatActivity {
        EditText phonenumber;
        Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);



                  phonenumber = findViewById(R.id.etNumber);
                  btn = findViewById(R.id.btn);

                  btn.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          String phone = phonenumber.getText().toString().trim();
                          Intent intent = new Intent(Intent.ACTION_DIAL);
                          intent.setData(Uri.parse("tel:"+phone));
                          startActivity(intent);
                      }
                  });

    }
}