package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Numero;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class NumeroCatalogo extends Catalogos<Numero> {


    public static NumeroCatalogo numeroCatalogo;

    private NumeroCatalogo() {
        super();
    }

    public static NumeroCatalogo getInstance() {
        if (numeroCatalogo == null) {
            numeroCatalogo = new NumeroCatalogo();
        }
        return numeroCatalogo;
    }

    @Override
    public Numero newT() {
        return new Numero();
    }

    @Override
    public boolean processNewT(Numero numero) {
        System.out.println("Teclee su número");
        numero.setNumero(ReadUtil.readInt());
        return true;
    }

    @Override
    public void processEdit(Numero numero) {
        System.out.println("Id del Número " + numero.getId( ) );
        System.out.println("Número a editar: " + numero.getNumero( ) );
        System.out.println("Teclee el valor nuevo del número" );
        numero.setNumero( ReadUtil.readInt( ) );
    }
}
