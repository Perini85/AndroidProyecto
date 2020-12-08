package com.example.sistema_academico2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button btn = (Button) findViewById(R.id.botonAlumno);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), CrudAlumno.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn1 = (Button) findViewById(R.id.botonlista);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), CrudProfesores.class);
                startActivityForResult(intent, 0);
            }
        });


        Button btn2 = (Button) findViewById(R.id.localizacion);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Telefono.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn3 = (Button) findViewById(R.id.gallery);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Galeria.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btn4 = (Button) findViewById(R.id.videoCaptura);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SeleccionarVideo.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}