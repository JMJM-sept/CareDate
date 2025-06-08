package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

public class ListaCatalogos extends LecturaAccion {

    public static ListaCatalogos listaCatalogos;

    private ListaCatalogos() {
    }

    public static ListaCatalogos getInstance() {
        if (listaCatalogos == null) {
            listaCatalogos = new ListaCatalogos();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione una opción");
        System.out.println("1.-Estado");
        System.out.println("2.-Municipio");
        System.out.println("3.-Colonia");
        System.out.println("4.-Calle");
        System.out.println("5.-Número");
        System.out.println("6.-CP");
        System.out.println("7.-Salir");

    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 7;
    }

    @Override
    public void procesaOpcion() {
        Ejecutable ejecutable = null;

        switch (opcion) {
            case 1:
                ejecutable = EstadoCatalogo.getInstance();
                break;
            case 2:
                ejecutable = MunicipioCatalogo.getInstance();
                break;
            case 3:
                ejecutable = ColoniaCatalogo.getInstance();
                break;
            case 4:
                ejecutable = CalleCatalogo.getInstance();
                break;
            case 5:
                ejecutable = NumeroCatalogo.getInstance();
                break;
            case 6:
                ejecutable = CpCatalogo.getInstance();
                break;
        }
        ejecutable.setFlag(true);
        ejecutable.run();
    }

}
