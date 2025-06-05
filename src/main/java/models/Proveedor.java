package models;

import java.util.List;
import java.util.UUID;

public class Proveedor {
    private String id;
    private String nombre;
    private String contacto;
    private String direccion;
    private List<String> productosSuministrados; // IDs de productos

    public Proveedor(String nombre, String contacto, String direccion) {
        this.id = "PROV-" + UUID.randomUUID().toString();
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getContacto() { return contacto; }
    public String getDireccion() { return direccion; }
    public List<String> getProductosSuministrados() { return productosSuministrados; }

    // Métodos de negocio
    public void agregarProducto(String productoId) {
        productosSuministrados.add(productoId);
    }

    public void actualizarContacto(String nuevoContacto) {
        this.contacto = nuevoContacto;
    }
}