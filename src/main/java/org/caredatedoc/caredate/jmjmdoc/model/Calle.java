package org.caredatedoc.caredate.jmjmdoc.model;

public class Calle extends Catalogo {

    private String nombre;

    public Calle() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Calle{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
