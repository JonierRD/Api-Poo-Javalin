package models;

import java.time.LocalDate;
import java.util.List;

public class Factura {
    private String id;
    private String clienteId;
    private LocalDate fecha;
    private List<String> items;
    private double total;

    public Factura() {}

    public Factura(String id, String clienteId, LocalDate fecha, List<String> items, double total) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.items = items;
        this.total = total;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public List<String> getItems() { return items; }
    public void setItems(List<String> items) { this.items = items; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}