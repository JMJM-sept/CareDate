package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Paciente;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import java.util.Scanner;

public class RegistroPaciente implements Ejecutable {

    private static RegistroPaciente instance = new RegistroPaciente();
    private boolean flag = false;

    private RegistroPaciente() {}

    public static RegistroPaciente getInstance() {
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
        String nombre = "", aPaterno = "", aMaterno = "", curp = "", fechaNac = "", email = "";
        char sexo = ' ';

        try {
            // Nombre
            while (true) {
                System.out.println("::::: REGISTRO PACIENTE :::::");
                System.out.print("Nombre: ");
                nombre = sc.nextLine().trim();
                if (!nombre.isEmpty()) break;
                System.out.println(" El nombre no puede estar vacío.");
            }

            // Apellido Paterno
            while (true) {
                System.out.print("Apellido Paterno: ");
                aPaterno = sc.nextLine().trim();
                if (!aPaterno.isEmpty()) break;
                System.out.println(" El apellido paterno no puede estar vacío.");
            }

            // Apellido Materno
            while (true) {
                System.out.print("Apellido Materno: ");
                aMaterno = sc.nextLine().trim();
                if (!aMaterno.isEmpty()) break;
                System.out.println(" El apellido materno no puede estar vacío.");
            }

            // CURP
            while (true) {
                System.out.print("CURP (18 caracteres): ");
                curp = sc.nextLine().trim().toUpperCase();
                if (curp.length() == 18 && curp.matches("[A-Z0-9]{18}")) break;
                System.out.println(" La CURP debe tener exactamente 18 caracteres alfanuméricos.");
            }

            // Fecha de Nacimiento
            while (true) {
                System.out.print("Fecha de Nacimiento (yyyy-MM-dd): ");
                fechaNac = sc.nextLine().trim();
                if (fechaNac.matches("\\d{4}-\\d{2}-\\d{2}")) break;
                System.out.println(" El formato debe ser yyyy-MM-dd (ej: 1990-05-21).");
            }

            // Sexo
            while (true) {
                System.out.print("Sexo (M/F): ");
                String input = sc.nextLine().trim().toUpperCase();
                if (input.length() == 1 && (input.charAt(0) == 'M' || input.charAt(0) == 'F')) {
                    sexo = input.charAt(0);
                    break;
                }
                System.out.println(" Solo se acepta 'M' o 'F'.");
            }

            // Correo electrónico
            while (true) {
                System.out.print("Correo electrónico: ");
                email = sc.nextLine().trim();
                if (email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) break;
                System.out.println(" El correo no es válido. Usa un formato como usuario@dominio.com");
            }

            // Crear el paciente
            Paciente paciente = new Paciente();

            System.out.println("\n~~~~~ REGISTRO EXITOSO ~~~~~");

        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Error inesperado: " + e.getMessage());
        }

    }
}