package com.example.norgan.recaudaciones03;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by norgan on 26/04/2018.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderPersonajes> implements View.OnClickListener{

    List<DatosPersonales> listaPersonas;
    private View.OnClickListener listener;

    public Adaptador(List<DatosPersonales> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.importa_datos,parent,false);
        RecyclerView.LayoutParams  layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);

        view.setOnClickListener(this);

        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int position) {

        holder.idCodigo.setText(listaPersonas.get(position).getCodigo().toString());
        holder.idNombre.setText(listaPersonas.get(position).getNombre().toString());
        holder.idApellido.setText(listaPersonas.get(position).getApellido().toString());
        //holder.imagenLista.setImageResource(listaPersonas.get(position).getFoto());


    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }


    public void setOnClickListener(View.OnClickListener listener){

        this.listener = listener;

    }

    @Override
    public void onClick(View v) {

        if (listener !=null){

            listener.onClick(v);
        }

    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

        TextView idCodigo,idNombre,idApellido;
        ImageView imagenLista;


        public ViewHolderPersonajes(View itemView) {
            super(itemView);


            idCodigo = (TextView)itemView.findViewById(R.id.idCodigo);
            idNombre = (TextView)itemView.findViewById(R.id.idNombre);
            idApellido = (TextView)itemView.findViewById(R.id.idApellido);
            //imagenLista = (ImageView)itemView.findViewById(R.id.imagenLista);

        }
    }
}
