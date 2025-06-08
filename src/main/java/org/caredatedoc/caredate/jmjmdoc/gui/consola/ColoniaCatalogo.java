package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Colonia;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class ColoniaCatalogo extends Catalogos<Colonia> {

    public static ColoniaCatalogo coloniaCatalogo;

    private ColoniaCatalogo() {
        super();
    }

    public static ColoniaCatalogo getInstance() {
        if (coloniaCatalogo == null) {
            coloniaCatalogo = new ColoniaCatalogo();
        }
        return coloniaCatalogo;
    }

    @Override
    public Colonia newT() {
        return new Colonia();
    }

    @Override
    public boolean processNewT(Colonia colonia) {
        System.out.println("Teclee una colonia");
        colonia.setNombre(ReadUtil.read());
        return true;
    }

    @Override
    public void processEdit(Colonia colonia) {
        System.out.println("Id de la Colonia " + colonia.getId());
        System.out.println("Colonia a editar: " + colonia.getNombre());
        System.out.println("Teclee el valor nuevo de la colonia");
        colonia.setNombre(ReadUtil.read());
    }
}
