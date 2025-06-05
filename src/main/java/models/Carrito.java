package models;

import java.util.List;

public class Carrito {
    private String id;
    private String usuarioId;
    private List<String> productosIds;
    private double total;

    public Carrito() {}

    public Carrito(String id, String usuarioId, List<String> productosIds, double total) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.productosIds = productosIds;
        this.total = total;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public List<String> getProductosIds() { return productosIds; }
    public void setProductosIds(List<String> productosIds) { this.productosIds = productosIds; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}