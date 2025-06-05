package models;

import java.util.List;
import java.util.UUID;

public class Pedido {
    private String id;
    private String usuarioId;
    private List<String> productosIds;
    private double total;
    private String estado; // "PENDIENTE", "ENVIADO", "ENTREGADO"

    // Constructor simplificado
    public Pedido(String usuarioId, List<String> productosIds) {
        this.id = UUID.randomUUID().toString();
        this.usuarioId = usuarioId;
        this.productosIds = productosIds;
        this.estado = "PENDIENTE";
        this.total = calcularTotalBasico(); // Método interno
    }

    private double calcularTotalBasico() {
        // Ejemplo básico: $10 por producto (reemplázalo con tu lógica)
        return productosIds.size() * 10.0;
    }

    // Getters/Setters (mismos que antes)
    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public List<String> getProductosIds() { return productosIds; }
    public double getTotal() { return total; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}