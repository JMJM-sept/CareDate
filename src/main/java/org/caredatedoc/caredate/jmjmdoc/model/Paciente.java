package org.caredatedoc.caredate.jmjmdoc.model;

public class Paciente extends Catalogo  {
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String curp;
    private String fechaNac;
    private char sexo;
    private String email;

    public Paciente() {
        this.setNombre(nombre);
        this.setaPaterno(aPaterno);
        this.setaMaterno(aMaterno);
        this.setCurp(curp);
        this.setFechaNac(fechaNac);
        this.setSexo(sexo);
        this.setEmail(email);
    }

    public Paciente(String nombre, String aPaterno, String aMaterno, String curp, String fechaNac, String email, char sexo) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        if (aPaterno != null && !aPaterno.trim().isEmpty()) {
            this.aPaterno = aPaterno.trim();
        } else {
            throw new IllegalArgumentException("El apellido paterno no puede estar vacío.");
        }
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        if (aMaterno != null && !aMaterno.trim().isEmpty()) {
            this.aMaterno = aMaterno.trim();
        } else {
            throw new IllegalArgumentException("El apellido materno no puede estar vacío.");
        }
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        if (curp != null) {
            curp = curp.trim().toUpperCase();
            if (curp.length() == 18 && curp.matches("[A-Z0-9]{18}")) {
                this.curp = curp;
            } else {
                throw new IllegalArgumentException("La CURP debe tener exactamente 18 caracteres alfanuméricos.");
            }
        } else {
            throw new IllegalArgumentException("La CURP no puede ser nula.");
        }
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        sexo = Character.toUpperCase(sexo);
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Sexo inválido. Usa 'M' o 'F'.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            this.email = email.trim();
        } else {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", aPaterno='" + aPaterno + '\'' +
                ", aMaterno='" + aMaterno + '\'' +
                ", curp='" + curp + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", sexo=" + sexo +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}