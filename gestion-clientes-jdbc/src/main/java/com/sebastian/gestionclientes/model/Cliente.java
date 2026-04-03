package com.sebastian.gestionclientes.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Cliente {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private Timestamp fechaRegistro;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(int id, String nombre, String apellido, String correo, String telefono, Timestamp fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return id == cliente.id
                && Objects.equals(nombre, cliente.nombre)
                && Objects.equals(apellido, cliente.apellido)
                && Objects.equals(correo, cliente.correo)
                && Objects.equals(telefono, cliente.telefono)
                && Objects.equals(fechaRegistro, cliente.fechaRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, correo, telefono, fechaRegistro);
    }
}
