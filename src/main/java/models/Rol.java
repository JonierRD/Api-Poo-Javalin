package models;

import java.util.Arrays;
import java.util.List;

public class Rol {
    private String id;
    private String nombre;
    private List<String> permisos; // Ej: ["CREAR_PRODUCTO", "EDITAR_USUARIO"]

    public Rol(String nombre, String... permisos) {
        this.nombre = nombre;
        this.permisos = Arrays.asList(permisos);
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<String> getPermisos() { return permisos; }

    // Gestión de permisos
    public void agregarPermiso(String permiso) {
        if (!permisos.contains(permiso)) permisos.add(permiso);
    }
    public boolean tienePermiso(String permiso) {
        return permisos.contains(permiso);
    }
}