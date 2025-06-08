package org.caredatedoc.caredate.jmjmdoc.model;

public class Municipio extends Catalogo {

    private String nombre;

    public Municipio() {
    }

    public String getNombre() {
        return  nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
