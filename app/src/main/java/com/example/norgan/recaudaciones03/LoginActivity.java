package com.example.norgan.recaudaciones03;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextView iniciar,salir;
    EditText idUsuario,idContrasena;

    RequestQueue request;
    JSONArray ja;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        iniciar = (TextView)findViewById(R.id.iniciar);
        salir = (TextView)findViewById(R.id.salir);
        idUsuario = (EditText)findViewById(R.id.idUsuario);
        idContrasena = (EditText)findViewById(R.id.idContrasena);

        request = Volley.newRequestQueue(getApplicationContext());


        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //login("http://192.168.1.40/Recaudaciones01/login.php?usuario="+idUsuario.getText().toString()+"&conta="+idContrasena.getText().toString()+"");

                Intent intent1 = new Intent(LoginActivity.this,PrincipalActivity.class);
                startActivity(intent1);

            }
        });



        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });



    }


    private  void login(String URL){

      Log.i("url",""+URL);

        request = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    ja = new JSONArray(response);

                    String conta = ja.getString(0);

                    if (conta.equals(idContrasena.getText().toString())){

                        Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(LoginActivity.this,PrincipalActivity.class);
                        startActivity(intent1);


                    }else{

                        Toast.makeText(LoginActivity.this, "Verifique contraseña", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(LoginActivity.this, "El usuario no  existe en la BD", Toast.LENGTH_SHORT).show();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(LoginActivity.this, "No en la BD"+error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        request.add(stringRequest);
    }
}
