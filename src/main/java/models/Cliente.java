package models;

import java.util.UUID;

public class Cliente {
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String tipo; // "NATURAL", "EMPRESA"

    public Cliente(String nombre, String email, String telefono, String tipo) {
        this.id = "CLI-" + UUID.randomUUID().toString();
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getTipo() { return tipo; }

    // Métodos de negocio
    public void actualizarContacto(String nuevoTelefono, String nuevoEmail) {
        this.telefono = nuevoTelefono;
        this.email = nuevoEmail;
    }
}