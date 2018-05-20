package com.example.norgan.recaudaciones03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReposrtesActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    TextView tvTotalPagado;

    RecyclerView recyclerReporte;
    ArrayList<DatosReporte> listareporte;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reposrtes);

        listareporte = new ArrayList<>();

        recyclerReporte = (RecyclerView)findViewById(R.id.recyclerReporte);
        tvTotalPagado = (TextView)findViewById(R.id.tvTotalPagado);

        recyclerReporte.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        recyclerReporte.setHasFixedSize(true);

        request = Volley.newRequestQueue(getApplicationContext());

        llenarreporte();

    }




    private void llenarreporte() {

        // borrado hoy String url = "http://192.168.1.34/Recaudaciones01/consultarreporte.php";
        String url ="http://192.168.1.39/joaquin/consultarreporte.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(jsonObjectRequest);



    }


    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(this, "no se pudo entrar", Toast.LENGTH_SHORT).show();
        Log.d("Error",error.toString());

    }

    @Override
    public void onResponse(JSONObject response) {


        DatosReporte datos =null;
        // borre hoy JSONArray jsons = response.optJSONArray("reporteusuario");
        JSONArray jsons = response.optJSONArray("recaudacion");


            try {
                for (int a =0; a<jsons.length();a++){
                    datos = new DatosReporte();
                    JSONObject  jsonObject = null;
                jsonObject = jsons.getJSONObject(a);

                datos.setPrograma(jsonObject.optString("rec_dependencia"));
                datos.setConcepto(jsonObject.optString("re_concepto"));
                datos.setNumrecibo(jsonObject.optString("rec_numero"));
                datos.setFecha(jsonObject.optString("rec_fecha"));
                datos.setValor(jsonObject.optString("rec_importe"));
                listareporte.add(datos);
                     // borrado hoy datos.setPrograma(jsonObject.optString("programa"));
                    // borrado hoy datos.setConcepto(jsonObject.optString("concepto"));
                    // borrado hoy datos.setNumrecibo(jsonObject.optString("numrecibo"));
                    // borrado hoy datos.setFecha(jsonObject.optString("fecha"));
                    // borrado hoy datos.setValor(jsonObject.optString("valor"));
                    // borrado hoy listareporte.add(datos);


            }

            AdaptadorReporte adaptadorReporte = new AdaptadorReporte(listareporte);
                recyclerReporte.setAdapter(adaptadorReporte);



        } catch (JSONException e) {
                e.printStackTrace();

                Toast.makeText(this, "NO SE PUDO CON LA CONEXION", Toast.LENGTH_SHORT).show();
            }


    }
}
