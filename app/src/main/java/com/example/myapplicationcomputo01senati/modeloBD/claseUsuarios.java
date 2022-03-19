package com.example.myapplicationcomputo01senati.modeloBD;

public class claseUsuarios {
    private String nombres,apellido,usuario,correo,clave;

    public claseUsuarios(String nombres, String apellido, String usuario, String correo, String clave) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
