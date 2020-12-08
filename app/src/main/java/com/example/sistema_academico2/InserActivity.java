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


public class InserActivity extends AppCompatActivity {
    EditText usuario, password, nombres, apellidos;
    Button btninsertar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inser);

        usuario=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        nombres=(EditText)findViewById(R.id.nombres);
        apellidos=(EditText)findViewById(R.id.apellidos);
        btninsertar=(Button)findViewById(R.id.btninsertar);


        btninsertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ejecutarServicio("http://192.168.18.16:80/servicios/insertar_usuario.php");
            }
        });
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
                parametros.put("usuario", usuario.getText().toString());
                parametros.put("password", password.getText().toString());
                parametros.put("nombres", nombres.getText().toString());
                parametros.put("apellidos", apellidos.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    //interaccion de boton
    public void onClick(View view) {
        Intent intent = new Intent (view.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);

    }
}