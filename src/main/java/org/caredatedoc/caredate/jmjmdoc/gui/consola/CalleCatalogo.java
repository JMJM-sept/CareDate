package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Calle;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class CalleCatalogo extends Catalogos<Calle>{

    public static CalleCatalogo calleCatalogo;

    private CalleCatalogo() {
        super();
    }

    public static CalleCatalogo getInstance() {
        if (calleCatalogo == null) {
            calleCatalogo = new CalleCatalogo();
        }
        return calleCatalogo;
    }

    @Override
    public Calle newT() {
        return new Calle();
    }

    @Override
    public boolean processNewT(Calle calle) {
        System.out.println("Teclee una calle");
        calle.setNombre(ReadUtil.read());
        return true;
    }

    @Override
    public void processEdit(Calle calle) {
        System.out.println("Id de ña Calle " + calle.getId( ) );
        System.out.println("Calle a editar: " + calle.getNombre( ) );
        System.out.println("Teclee el valor nuevo de la calle" );
        calle.setNombre( ReadUtil.read( ) );
    }
}
