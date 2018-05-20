package com.example.norgan.recaudaciones03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {


    Button btnBuscar;
    EditText txtnombre;
    RecyclerView recyclerPrincipal;
    ArrayList<DatosPersonales> listaPersonas;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        listaPersonas = new ArrayList<>();


        recyclerPrincipal = (RecyclerView)findViewById(R.id.recyclerPrincipal);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        txtnombre = (EditText)findViewById(R.id.txtnombre);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llenarDatos();

                // esto borre 1 Intent intent3= new Intent(PrincipalActivity.this,ReposrtesActivity.class);
                // esto borre 1 startActivity(intent3);

            }
        });


        recyclerPrincipal.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerPrincipal.setHasFixedSize(true);

        request = Volley.newRequestQueue(getApplicationContext());





        // esto borre 1 llenarDatos();

       //Adaptador ad = new Adaptador(listaPersonas);
       //recyclerPrincipal.setAdapter(ad);



    }

    private void llenarDatos() {

        //String url = "http://192.168.1.35/Recaudaciones01/consultarListasusuario.php";
        //String url = "http://192.168.1.35/Recaudaciones01/consultarxcodigo.php?id_cliente="+txtnombre.getText().toString()+"";
        // borrado hoy String url ="http://192.168.1.35/Recaudaciones01/consultarxnombre.php?nombre_cliente="+txtnombre.getText().toString()+"";
        String url = "http://192.168.1.39/joaquin/consultarxnombre.php?rec_nombre="+txtnombre.getText().toString()+"";

        url = url.replace(" ","%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);

        //listaPersonas.add(new DatosPersonales("13200177","Hector","Ramon",R.drawable.regi));
        //listaPersonas.add(new DatosPersonales("13200178","Johana","Paulino",R.drawable.regi));
        //listaPersonas.add(new DatosPersonales("13200171","Alessandra","Sanchez",R.drawable.regi));
        //listaPersonas.add(new DatosPersonales("13200172","Juana","Vasqwuez",R.drawable.regi));
        //listaPersonas.add(new DatosPersonales("13200173","Marisol","Ramiez",R.drawable.regi));
        //listaPersonas.add(new DatosPersonales("13200174","Carla","Contreras",R.drawable.regi));


    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(this, "No se pudo encontrar", Toast.LENGTH_SHORT).show();
        Log.d("ERROR",error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {

       DatosPersonales cliente = null;
       // borrado hoy JSONArray json = response.optJSONArray("cliente");
        JSONArray json = response.optJSONArray("recaudacioness");
       JSONObject jsonObject = null;

        try {

            for (int i=0 ; i<json.length();i++){
                cliente =  new DatosPersonales();

                jsonObject =  json.getJSONObject(i);

                cliente.setCodigo(jsonObject.optString("rec_codigo"));
                cliente.setNombre(jsonObject.optString("rec_nombre"));
                cliente.setApellido(jsonObject.optString("rec_dependencia"));
                listaPersonas.add(cliente);
                // borrado hoy cliente.setCodigo(jsonObject.optString("id_cliente"));
                // borrado hoy cliente.setNombre(jsonObject.optString("nombre_cliente"));
                // borrado hoy cliente.setApellido(jsonObject.optString("domicilio_cliente"));
                // borrado hoy listaPersonas.add(cliente);

            }



            Adaptador adaptador = new Adaptador(listaPersonas);

            adaptador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent3= new Intent(PrincipalActivity.this,ReposrtesActivity.class);
                    startActivity(intent3);

                    Toast.makeText(getApplicationContext(), "Selecciono"+listaPersonas.get(recyclerPrincipal.getChildAdapterPosition(v)).getCodigo(), Toast.LENGTH_SHORT).show();


                }
            });
            recyclerPrincipal.setAdapter(adaptador);


        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "NO SE PUSO CON LA CONEXION", Toast.LENGTH_SHORT).show();
        }


    }
}

