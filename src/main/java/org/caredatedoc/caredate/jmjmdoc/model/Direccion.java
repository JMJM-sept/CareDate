package org.caredatedoc.caredate.jmjmdoc.model;

public class Direccion extends Catalogo {

    private String estado;
    private String municipio;
    private String colonia;
    private String calle;
    private int numero;
    private int cp;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "estado='" + estado + '\'' +
                ", municipio='" + municipio + '\'' +
                ", colonia='" + colonia + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", cp=" + cp +
                ", id=" + id +
                '}';
    }

}
