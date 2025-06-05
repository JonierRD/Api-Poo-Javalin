package models;

import java.time.LocalDate;

public class Pago {
    private String id;
    private String facturaId;
    private double monto;
    private LocalDate fecha;
    private String metodo;

    public Pago() {}

    public Pago(String id, String facturaId, double monto, LocalDate fecha, String metodo) {
        this.id = id;
        this.facturaId = facturaId;
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFacturaId() { return facturaId; }
    public void setFacturaId(String facturaId) { this.facturaId = facturaId; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }
}