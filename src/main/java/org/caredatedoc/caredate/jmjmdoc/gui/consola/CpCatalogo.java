package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Cp;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class CpCatalogo extends Catalogos<Cp> {

    public static CpCatalogo cpCatalogo;

    private CpCatalogo() {
        super();
    }

    public static CpCatalogo getInstance() {
        if (cpCatalogo == null) {
            cpCatalogo = new CpCatalogo();
        }
        return cpCatalogo;
    }

    @Override
    public Cp newT() {
        return new Cp();
    }

    @Override
    public boolean processNewT(Cp cp) {
        System.out.println("Teclee su código postal");
        cp.setNumero(ReadUtil.readInt());
        return true;
    }

    @Override
    public void processEdit(Cp cp) {
        System.out.println("Id del Código Postal " + cp.getId( ) );
        System.out.println("Cp a editar: " + cp.getNumero( ) );
        System.out.println("Teclee el valor nuevo del cp" );
        cp.setNumero( ReadUtil.readInt( ) );
    }


}
