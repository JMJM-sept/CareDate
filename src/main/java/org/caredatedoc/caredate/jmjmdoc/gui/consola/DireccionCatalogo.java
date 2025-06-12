package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

public class DireccionCatalogo extends Catalogos<Direccion>{

    public static DireccionCatalogo direccionCatalogo;

    private DireccionCatalogo() {
        super();
    }
    public static DireccionCatalogo getInstance() {
        if (direccionCatalogo == null) {
            direccionCatalogo = new DireccionCatalogo();
        }
        return direccionCatalogo;
    }

    @Override
    public Direccion newT() {
        return new Direccion();
    }

    @Override
    public boolean processNewT(Direccion direccion) {
        System.out.println("Teclee su estado" );
        direccion.setEstado( ReadUtil.read( ) );
        System.out.println("Teclee su municipio");
        direccion.setMunicipio(ReadUtil.read());
        System.out.println("Teclee su colonia");
        direccion.setColonia(ReadUtil.read());
        System.out.println("Teclee su calle");
        direccion.setCalle(ReadUtil.read());
        System.out.println("Teclee su número de casa");
        direccion.setNumero(ReadUtil.readInt());
        System.out.println("Teclee su cp");
        direccion.setCp(ReadUtil.readInt());
        return true;
    }

    @Override
    public void processEdit(Direccion direccion) {
        System.out.println("Id de la dirección a editar " + direccion.getId( ) );
        System.out.println("Estado a editar: " + direccion.getEstado( ) );
        System.out.println("Teclee el valor nuevo del Estado" );
        direccion.setEstado( ReadUtil.read( ) );
        System.out.println("-------------------------------------------------");
        System.out.println("Municipio a editar: " + direccion.getMunicipio( ) );
        System.out.println("Teclee el valor nuevo del Municipio" );
        direccion.setMunicipio( ReadUtil.read( ) );
        System.out.println("-------------------------------------------------");
        System.out.println("Colonia a editar: " + direccion.getColonia( ) );
        System.out.println("Teclee el valor nuevo de la Colonia" );
        direccion.setColonia( ReadUtil.read( ) );
        System.out.println("-------------------------------------------------");
        System.out.println("Calle a editar: " + direccion.getCalle( ) );
        System.out.println("Teclee el valor nuevo de La Calle" );
        direccion.setCalle( ReadUtil.read( ) );
        System.out.println("-------------------------------------------------");
        System.out.println("Número a editar: " + direccion.getNumero( ) );
        System.out.println("Teclee el valor nuevo del Número" );
        direccion.setNumero( ReadUtil.readInt( ) );
        System.out.println("-------------------------------------------------");
        System.out.println("CP a editar: " + direccion.getCp( ) );
        System.out.println("Teclee el valor nuevo del CP" );
        direccion.setCp( ReadUtil.readInt( ) );

    }
}
