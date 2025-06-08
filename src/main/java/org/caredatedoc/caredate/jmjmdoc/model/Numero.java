package org.caredatedoc.caredate.jmjmdoc.model;

public class Numero extends Catalogo {

    private Integer numero;

    public Numero() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public Integer getId() {
        return Integer.valueOf("Número{" +
                "numero='" + numero + '\'' +
                ", id=" + id +
                '}');
    }
}
