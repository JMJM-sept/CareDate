package org.caredatedoc.caredate.jmjmdoc.model;

public class Direccion extends Catalogo {

    private String alcaldíaP;
    private String coloniaP;
    private String calleP;
    private int numeroP;
    private int cpP;

    public Direccion(String alcaldiaP, String coloniaP, String calleP, int numeroP, int cpP) {
    }

    public Direccion() {

    }

    public String getAlcaldíaP() {
        return alcaldíaP;
    }

    public void setAlcaldíaP(String alcaldíaP) {
        this.alcaldíaP = alcaldíaP;
    }

    public String getColoniaP() {
        return coloniaP;
    }

    public void setColoniaP(String coloniaP) {
        this.coloniaP = coloniaP;
    }

    public String getCalleP() {
        return calleP;
    }

    public void setCalleP(String calleP) {
        this.calleP = calleP;
    }

    public int getNumeroP() {
        return numeroP;
    }

    public void setNumeroP(int numeroP) {
        this.numeroP = numeroP;
    }

    public int getCpP() {
        return cpP;
    }

    public void setCpP(int cpP) {
        this.cpP = cpP;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "alcaldíaP='" + alcaldíaP + '\'' +
                ", coloniaP='" + coloniaP + '\'' +
                ", calleP='" + calleP + '\'' +
                ", numeroP=" + numeroP +
                ", cpP=" + cpP +
                ", id=" + id +
                '}';
    }

}
