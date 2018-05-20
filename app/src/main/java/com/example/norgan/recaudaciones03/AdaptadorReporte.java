package com.example.norgan.recaudaciones03;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdaptadorReporte extends RecyclerView.Adapter<AdaptadorReporte.ViewHolderReportes> {

    List<DatosReporte> listareporte;

    public AdaptadorReporte(List<DatosReporte> listareporte) {
        this.listareporte = listareporte;
    }



    @Override
    public ViewHolderReportes onCreateViewHolder(ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.reportesdatos,parent,false);
        RecyclerView.LayoutParams layoutParamss = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParamss);


        return new ViewHolderReportes(vista);
    }



    @Override
    public void onBindViewHolder(ViewHolderReportes holder, int position) {

        holder.idProgramaRe.setText(listareporte.get(position).getPrograma().toString());
        holder.idConceptoRe.setText(listareporte.get(position).getConcepto().toString());
        holder.idReciboRe.setText(listareporte.get(position).getNumrecibo().toString());
        holder.idFechaRe.setText(listareporte.get(position).getFecha().toString());
        holder.idValorRe.setText(listareporte.get(position).getValor().toString());



    }


    @Override
    public int getItemCount() {
        return listareporte.size();
    }



    public class ViewHolderReportes extends RecyclerView.ViewHolder {

        TextView idProgramaRe,idConceptoRe,idReciboRe,idFechaRe,idValorRe;


        public ViewHolderReportes(View itemView) {
            super(itemView);


            idProgramaRe = (TextView)itemView.findViewById(R.id.idProgramaRe);
            idConceptoRe = (TextView)itemView.findViewById(R.id.idConceptoRe);
            idReciboRe = (TextView)itemView.findViewById(R.id.idReciboRe);
            idFechaRe = (TextView)itemView.findViewById(R.id.idFechaRe);
            idValorRe = (TextView)itemView.findViewById(R.id.idValorRe);




        }
    }
}
