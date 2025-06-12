package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.DireccionClinica;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class DireccionClinicaCatalogo extends Catalogos<DireccionClinica> {

    private static DireccionClinicaCatalogo instance;

    private DireccionClinicaCatalogo() {
        super();
    }

    public static DireccionClinicaCatalogo getInstance() {
        if (instance == null) {
            instance = new DireccionClinicaCatalogo();
        }
        return instance;
    }

    @Override
    public DireccionClinica newT() {
        return new DireccionClinica();
    }

    @Override
    public boolean processNewT(DireccionClinica dir) {
        System.out.println("Teclee su estado:");
        dir.setEstadoC(ReadUtil.read());
        System.out.println("Teclee su municipio:");
        dir.setMunicipioC(ReadUtil.read());
        System.out.println("Teclee su colonia:");
        dir.setColoniaC(ReadUtil.read());
        System.out.println("Teclee su calle:");
        dir.setCalleC(ReadUtil.read());
        System.out.println("Teclee su número:");
        dir.setNumeroC(ReadUtil.readInt());
        System.out.println("Teclee su código postal:");
        dir.setCpC(ReadUtil.readInt());
        return true;
    }

    @Override
    public void processEdit(DireccionClinica dir) {
        System.out.println("Editando dirección clínica...");
        System.out.println("Estado actual: " + dir.getEstadoC());
        System.out.println("Nuevo estado:");
        dir.setEstadoC(ReadUtil.read());

        System.out.println("Municipio actual: " + dir.getMunicipioC());
        System.out.println("Nuevo municipio:");
        dir.setMunicipioC(ReadUtil.read());

        System.out.println("Colonia actual: " + dir.getColoniaC());
        System.out.println("Nueva colonia:");
        dir.setColoniaC(ReadUtil.read());

        System.out.println("Calle actual: " + dir.getCalleC());
        System.out.println("Nueva calle:");
        dir.setCalleC(ReadUtil.read());

        System.out.println("Número actual: " + dir.getNumeroC());
        System.out.println("Nuevo número:");
        dir.setNumeroC(ReadUtil.readInt());

        System.out.println("CP actual: " + dir.getCpC());
        System.out.println("Nuevo CP:");
        dir.setCpC(ReadUtil.readInt());
    }
}