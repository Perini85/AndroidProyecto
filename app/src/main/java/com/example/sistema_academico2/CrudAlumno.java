package com.example.sistema_academico2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CrudAlumno extends AppCompatActivity {
    EditText nombres, apellidos, direccion, contacto;
    Button btnCreate;
    Button btnEdit;
    Button btnDelete;
    Button btnBack;
    //Button btnbuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_alumno);

        nombres=(EditText)findViewById(R.id.nombres);
        apellidos=(EditText)findViewById(R.id.apellidos);
        direccion=(EditText)findViewById(R.id.direccion);
        contacto=(EditText)findViewById(R.id.contacto);

        btnCreate=(Button)findViewById(R.id.btnCreate);
        btnEdit=(Button)findViewById(R.id.btnEdit);
        btnDelete=(Button)findViewById(R.id.btnDelete);


        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), menu.class);
                startActivityForResult(intent, 0);
            }
        });


        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ejecutarServicio("http://192.168.18.16:80/servicios/insertar_alumno.php");
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ejecutarServicio("http://192.168.18.16:80/servicios/editar_alumno.php");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ejecutarServicio("http://192.168.18.16:80/servicios/eliminar_alumno.php");
            }
        });
        /*
        btnbuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                buscarusuario("http://192.168.0.7:80/servicios/buscar_usuario.php?usuario="+usuario.getText()+"");
            }
        });*/
    }
    private void ejecutarServicio(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion Exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener (){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString()+"  Error en el desarrollo del codigo" ,Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombres", nombres.getText().toString());
                parametros.put("apellidos", apellidos.getText().toString());
                parametros.put("direccion", direccion.getText().toString());
                parametros.put("contacto", contacto.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    public void onClick(View view) {
        Intent intent = new Intent (view.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);

    }

}