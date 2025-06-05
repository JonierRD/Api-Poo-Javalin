package models;

import java.time.LocalDate;

public class Almacen {
    private String id;
    private String nombre;
    private String ubicacion;
    private double capacidadM2;
    private String tipo;
    private LocalDate fechaCreacion;

    // Constructor vacío
    public Almacen() {}

    // Constructor completo
    public Almacen(String id, String nombre, String ubicacion, double capacidadM2, String tipo, LocalDate fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadM2 = capacidadM2;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public double getCapacidadM2() { return capacidadM2; }
    public void setCapacidadM2(double capacidadM2) { this.capacidadM2 = capacidadM2; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}