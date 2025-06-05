package models;

import java.util.List;

public class Rol {
    private String id;
    private String nombre;
    private List<String> permisos;

    public Rol() {}

    public Rol(String id, String nombre, List<String> permisos) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<String> getPermisos() { return permisos; }
    public void setPermisos(List<String> permisos) { this.permisos = permisos; }
}