package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;
import org.caredatedoc.caredate.jmjmdoc.util.ReadUtil;

import java.util.Scanner;

public class RegistroDirPac implements Ejecutable  {

    private static final RegistroDirPac instance = new RegistroDirPac();
    private boolean flag = false;

    private RegistroDirPac() {}

    public static RegistroDirPac getInstance() {
        return instance;
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (!flag) return;

        Scanner sc = new Scanner(System.in);
        String calleP = "", coloniaP = "", alcaldiaP = "";
        int numeroP = 0, cpP = 0;

        try {
            // Alcaldía
            while (true) {
                System.out.println("REGISTRO DOMICILIO");
                System.out.print("Alcaldía: ");
                alcaldiaP = sc.nextLine().trim();
                if (!alcaldiaP.isEmpty()) break;
                System.out.println(" La alcaldía no puede estar vacía.");
            }

            // Colonia
            while (true) {
                System.out.print("Colonia: ");
                coloniaP = sc.nextLine().trim();
                if (!coloniaP.isEmpty()) break;
                System.out.println(" La colonia no puede estar vacía.");
            }

            // Calle
            while (true) {
                System.out.print("Calle: ");
                calleP = sc.nextLine().trim();
                if (!calleP.isEmpty()) break;
                System.out.println(" La calle no puede estar vacía.");
            }

            // Número casa
            while (true) {
                System.out.print("Número de casa: ");
                if (sc.hasNextInt()) {
                    numeroP = sc.nextInt();
                    if (numeroP > 0) break;
                    else System.out.println("El número debe ser mayor a 0.");
                } else {
                    System.out.println("Entrada inválida. Solo se permiten números.");
                    sc.next(); // Limpia la entrada inválida
                }
            }

            // Correo Postal
            while (true) {
                System.out.print("Codigo Postal: ");
                if (sc.hasNextInt()) {
                    cpP = sc.nextInt();
                    if (cpP > 0) break;
                    else System.out.println("El número debe ser mayor a 0.");
                } else {
                    System.out.println("Entrada inválida. Solo se permiten números.");
                    sc.next(); // Limpia la entrada inválida
                }
            }

            // Crear el domicilio
            Direccion direccion = new Direccion(alcaldiaP, coloniaP, calleP, numeroP, cpP);

            System.out.println("\n REGISTRO EXITOSO");

        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Error inesperado: " + e.getMessage());
        }

    }

    /*private static int contadorId = 1;

    private int id;
    private String calleP;
    private int numeroP;
    private String coloniaP;
    private int cpP;
    private String alcaldiaP;

    public RegistroDirPac() {
        this.id = contadorId++;
    }

    public Integer getId() {
        return id;
    }

    public String getCalleP() {
        return calleP;
    }

    public void setCalleP(String calleP) {
        if (calleP != null && !calleP.trim().isEmpty()) {
            this.calleP = calleP.trim();
        } else {
            throw new IllegalArgumentException("La calle no puede estar vacía.");
        }
    }

    public int getNumeroP() {
        return numeroP;
    }

    public void setNumeroP(int numeroP) {
        if (numeroP > 0) {
            this.numeroP = numeroP;
        } else {
            throw new IllegalArgumentException("El número debe ser mayor que cero.");
        }
    }

    public String getColoniaP() {
        return coloniaP;
    }

    public void setColoniaP(String coloniaP) {
        if (coloniaP != null && !coloniaP.trim().isEmpty()) {
            this.coloniaP = coloniaP.trim();
        } else {
            throw new IllegalArgumentException("La colonia no puede estar vacía.");
        }
    }

    public int getCpP() {
        return cpP;
    }

    public void setCpP(int cpP) {
        if (cpP > 0) {
            this.cpP = cpP;
        } else {
            throw new IllegalArgumentException("El código postal debe ser mayor que cero.");
        }
    }

    public String getAlcaldiaPC() {
        return alcaldiaP;
    }

    public void setAlcaldiaP(String alcaldiaP) {
        if (alcaldiaP != null && !alcaldiaP.trim().isEmpty()) {
            this.alcaldiaP = alcaldiaP.trim();
        } else {
            throw new IllegalArgumentException("La alcaldía no puede estar vacía.");
        }
    }

    @Override
    public String toString() {
        return "DireccionClinica{" +
                "id=" + id +
                ", calleP = '" + calleP + '\'' +
                ", numeroP = " + numeroP +
                ", coloniaP = '" + coloniaP + '\'' +
                ", cpP = " + cpP +
                ", municipioP = '" + alcaldiaP + '\'' +
                '}';
    }*/
}