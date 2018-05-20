package com.example.norgan.recaudaciones03;

/**
 * Created by norgan on 26/04/2018.
 */

public class DatosPersonales {

    private String codigo;
    private String nombre;
    private String apellido;
    private int foto;


    public DatosPersonales() {
    }

    public DatosPersonales(String codigo, String nombre, String apellido, int foto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
