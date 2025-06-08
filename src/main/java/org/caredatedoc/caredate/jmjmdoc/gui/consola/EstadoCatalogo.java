package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Estado;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class EstadoCatalogo extends Catalogos<Estado> {

    public static EstadoCatalogo estadoCatalogo;

    private EstadoCatalogo() {
        super();
    }

    public static EstadoCatalogo getInstance() {
        if (estadoCatalogo == null) {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    @Override
    public Estado newT() {
        return new Estado();
    }

    @Override
    public boolean processNewT(Estado estado) {
        System.out.println("Teclee un estado");
        estado.setNombre(ReadUtil.read());
        return true;
    }

    @Override
    public void processEdit(Estado estado) {
        System.out.println("Id del estado: " + estado.getId());
        System.out.println("Estado a editar: " + estado.getNombre());
        System.out.println("Teclee el valor del nuevo estado: ");
        estado.setNombre(ReadUtil.read());
    }
}
