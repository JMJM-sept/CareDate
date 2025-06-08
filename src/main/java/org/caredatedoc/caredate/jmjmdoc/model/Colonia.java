package org.caredatedoc.caredate.jmjmdoc.model;

public class Colonia extends Catalogo{

    private String nombre;

    public Colonia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Colonia{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
