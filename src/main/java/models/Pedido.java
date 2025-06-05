package models;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private String id;
    private String clienteId;
    private LocalDate fecha;
    private List<String> productos;
    private String estado;

    public Pedido() {}

    public Pedido(String id, String clienteId, LocalDate fecha, List<String> productos, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.productos = productos;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public List<String> getProductos() { return productos; }
    public void setProductos(List<String> productos) { this.productos = productos; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}