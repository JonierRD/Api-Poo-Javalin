package models;

import java.time.LocalDate;
import java.util.UUID;

public class Descuento {
    private String id;
    private String codigo;
    private double porcentaje;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activo;

    public Descuento(String codigo, double porcentaje, LocalDate fechaFin) {
        this.id = UUID.randomUUID().toString();
        this.codigo = codigo;
        this.porcentaje = porcentaje;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = fechaFin;
        this.activo = true;
    }

    // Añade este getter faltante
    public String getId() {
        return id;
    }

    // Resto de getters...
    public String getCodigo() { return codigo; }
    public double getPorcentaje() { return porcentaje; }
    public boolean estaActivo() {
        return activo && LocalDate.now().isBefore(fechaFin);
    }

    public void desactivar() { this.activo = false; }
}