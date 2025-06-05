package models;

import java.time.LocalDate;

public class Descuento {
    private String id;
    private String codigo;
    private double porcentaje;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activo;

    public Descuento() {}

    public Descuento(String id, String codigo, double porcentaje, LocalDate fechaInicio, LocalDate fechaFin, boolean activo) {
        this.id = id;
        this.codigo = codigo;
        this.porcentaje = porcentaje;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = activo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public double getPorcentaje() { return porcentaje; }
    public void setPorcentaje(double porcentaje) { this.porcentaje = porcentaje; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}