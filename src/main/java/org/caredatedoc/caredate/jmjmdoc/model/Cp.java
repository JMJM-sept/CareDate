package org.caredatedoc.caredate.jmjmdoc.model;

public class Cp extends Catalogo {

    private Integer numero;

    public Cp() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public Integer getId() {
        return Integer.valueOf("Cp{" +
                "número='" + numero + '\'' +
                ", id=" + id +
                '}');
    }
}
