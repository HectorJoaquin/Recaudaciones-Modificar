package com.example.norgan.recaudaciones03;

public class DatosReporte {


    private String programa;
    private String concepto;
    private String numrecibo;
    private String fecha;
    private String valor;


    public DatosReporte() {
    }


    public DatosReporte(String programa, String concepto, String numrecibo, String fecha, String valor) {
        this.programa = programa;
        this.concepto = concepto;
        this.numrecibo = numrecibo;
        this.fecha = fecha;
        this.valor = valor;
    }


    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getNumrecibo() {
        return numrecibo;
    }

    public void setNumrecibo(String numrecibo) {
        this.numrecibo = numrecibo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
