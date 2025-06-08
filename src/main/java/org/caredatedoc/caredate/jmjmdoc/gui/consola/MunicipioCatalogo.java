package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Municipio;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class MunicipioCatalogo extends Catalogos<Municipio> {

    public static MunicipioCatalogo municipioCatalogo;
    private MunicipioCatalogo() {
        super();
    }

    public static MunicipioCatalogo getInstance() {
        if (municipioCatalogo == null) {
            municipioCatalogo = new MunicipioCatalogo();
        }
        return municipioCatalogo;
    }

    @Override
    public Municipio newT() {
        return new Municipio();
    }

    @Override
    public boolean processNewT(Municipio municipio) {
        System.out.println("Teclee un municipio");
        municipio.setNombre(ReadUtil.read());
        return true;
    }

    @Override
    public void processEdit(Municipio municipio) {
        System.out.println("Id del municipio " + municipio.getId());
        System.out.println("Municipio a editar: " + municipio.getNombre());
        System.out.println("Teclee el valor nueva del municipio");
        municipio.setNombre(ReadUtil.read());
    }
}
