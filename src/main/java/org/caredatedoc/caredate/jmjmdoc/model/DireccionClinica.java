package org.caredatedoc.caredate.jmjmdoc.model;

public class DireccionClinica extends Catalogo {

    private static int contadorId = 1;

    private int id;
    private String calleC;
    private int numeroC;
    private String coloniaC;
    private int cpC;
    private String municipioC;
    private String estadoC;

    public DireccionClinica() {
        this.id = contadorId++;
    }

    public Integer getId() {
        return id;
    }

    public String getCalleC() {
        return calleC;
    }

    public void setCalleC(String calleC) {
        if (calleC != null && !calleC.trim().isEmpty()) {
            this.calleC = calleC.trim();
        } else {
            throw new IllegalArgumentException("La calle no puede estar vacía.");
        }
    }

    public int getNumeroC() {
        return numeroC;
    }

    public void setNumeroC(int numeroC) {
        if (numeroC > 0) {
            this.numeroC = numeroC;
        } else {
            throw new IllegalArgumentException("El número debe ser mayor que cero.");
        }
    }

    public String getColoniaC() {
        return coloniaC;
    }

    public void setColoniaC(String coloniaC) {
        if (coloniaC != null && !coloniaC.trim().isEmpty()) {
            this.coloniaC = coloniaC.trim();
        } else {
            throw new IllegalArgumentException("La colonia no puede estar vacía.");
        }
    }

    public int getCpC() {
        return cpC;
    }

    public void setCpC(int cpC) {
        if (cpC > 0) {
            this.cpC = cpC;
        } else {
            throw new IllegalArgumentException("El código postal debe ser mayor que cero.");
        }
    }

    public String getMunicipioC() {
        return municipioC;
    }

    public void setMunicipioC(String municipioC) {
        if (municipioC != null && !municipioC.trim().isEmpty()) {
            this.municipioC = municipioC.trim();
        } else {
            throw new IllegalArgumentException("El municipio no puede estar vacío.");
        }
    }

    public String getEstadoC() {
        return estadoC;
    }

    public void setEstadoC(String estadoC) {
        if (estadoC != null && !estadoC.trim().isEmpty()) {
            this.estadoC = estadoC.trim();
        } else {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return "DireccionClinica{" +
                "id=" + id +
                ", calleC = '" + calleC + '\'' +
                ", numeroC = " + numeroC +
                ", coloniaC = '" + coloniaC + '\'' +
                ", cpC = " + cpC +
                ", municipioC = '" + municipioC + '\'' +
                ", estadoC = '" + estadoC + '\'' +
                '}';
    }

    /*
    @Override
    public String toString() {
        return String.format("ID: %d\nCalle: %s\nNúmero: %d\nColonia: %s\nCP: %d\nMunicipio: %s\nEstado: %s",
                id, calleC, numeroC, coloniaC, cpC, municipioC, estadoC);
    }
     */
}