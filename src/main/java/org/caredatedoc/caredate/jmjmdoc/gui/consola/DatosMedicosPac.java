package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Paciente;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;
import java.util.Scanner;

public class DatosMedicosPac implements Ejecutable{

    private static DatosMedicosPac instance = new DatosMedicosPac();
    private boolean flag = false;

    private DatosMedicosPac() {}

    public DatosMedicosPac(String tipoSangre, String medicamentos, String enfCronicas, String alergias, String cirugiasPre) {
    }

    public static DatosMedicosPac getInstance() {
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
        String tipoSangre = "", medicamentos = "", enfCronicas = "", alergias = "", cirugiasPre = "";

        try {
            // tipoSangre
            while (true) {
                System.out.println("::::: REGISTRO DATOS MÉDICOS PACIENTE :::::");
                System.out.print("Tipo de Sangre: ");
                tipoSangre = sc.nextLine().trim();
                if (!tipoSangre.isEmpty()) break;
                System.out.println(" El tipo de sangre no puede estar vacío.");
            }

            /// Medicamentos
            while (true) {
                System.out.print("¿Actualmente consume algún medicamento recetado por su médico? (S/N): ");
                String respuesta = sc.nextLine().trim().toUpperCase();

                if (respuesta.equals("S")) {
                    System.out.print("Indique qué medicamentos consume: ");
                    medicamentos = sc.nextLine().trim();
                    if (!medicamentos.isEmpty()) break;
                    System.out.println("La lista de medicamentos no puede estar vacía.");
                } else if (respuesta.equals("N")) {
                    medicamentos = "Ninguno";
                    break;
                } else {
                    System.out.println("Opción inválida. Escribe S para sí o N para no.");
                }
            }

            // Enfermedades Crónicas
                while (true) {
                    System.out.print("¿Actualmente sufre de alguna enfermedad crónica? (S/N): ");
                    String respuestaEnf = sc.nextLine().trim().toUpperCase();

                    if (respuestaEnf.equals("S")) {
                        System.out.print("Indique qué enfermedad crónica padece : ");
                        enfCronicas = sc.nextLine().trim();
                        if (!enfCronicas.isEmpty()) break;
                        System.out.println("Este campo no puede estar vacía.");
                    } else if (respuestaEnf.equals("N")) {
                        enfCronicas = "Ninguno";
                        break;
                    } else {
                        System.out.println("Opción inválida. Escribe S para sí o N para no.");
                    }
                }

                // Alergias
                while (true) {
                    System.out.print("¿Actualmente padece de alguna alergia? (S/N): ");
                    String respuestaAlg = sc.nextLine().trim().toUpperCase();

                    if (respuestaAlg.equals("S")) {
                        System.out.print("Indique qué alergia padece : ");
                        alergias = sc.nextLine().trim();
                        if (!alergias.isEmpty()) break;
                        System.out.println("Este campo no puede estar vacía.");
                    } else if (respuestaAlg.equals("N")) {
                        alergias = "Ninguno";
                        break;
                    } else {
                        System.out.println("Opción inválida. Escribe S para sí o N para no.");
                    }
                }

            // Cirugías Previas
            while (true) {
                System.out.print("¿Se ha realizado algún procedimiento quirúrgico? (S/N): ");
                String respuestaCir = sc.nextLine().trim().toUpperCase();

                if (respuestaCir.equals("S")) {
                    System.out.print("Indique qué cirugías se ha realizado: ");
                    cirugiasPre = sc.nextLine().trim();
                    if (!cirugiasPre.isEmpty()) break;
                    System.out.println("Este campo no puede estar vacía.");
                } else if (respuestaCir.equals("N")) {
                    cirugiasPre = "Ninguno";
                    break;
                } else {
                    System.out.println("Opción inválida. Escribe S para sí o N para no.");
                }
            }

            // Crear registro de datos médicos
            DatosMedicosPac datosMedicosPac = new DatosMedicosPac(tipoSangre, medicamentos, enfCronicas, alergias, cirugiasPre);

            System.out.println("\n~~~~~ REGISTRO EXITOSO ~~~~~");

        } catch (IllegalArgumentException e) {
            System.err.println("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Error inesperado: " + e.getMessage());
        }

    }

}
