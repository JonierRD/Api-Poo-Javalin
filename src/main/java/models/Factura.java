package models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Factura {
    private String id;
    private String pedidoId;
    private String clienteId; // Asegúrate de que este campo existe
    private LocalDateTime fechaEmision;
    private double subtotal;
    private double iva;
    private double total;
    private String estado; // "GENERADA", "PAGADA", "ANULADA"
    private List<String> items;

    public Factura(String pedidoId, String clienteId, double subtotal, List<String> items) {
        this.id = "FAC-" + UUID.randomUUID().toString();
        this.pedidoId = pedidoId;
        this.clienteId = clienteId; // Inicializado correctamente
        this.subtotal = subtotal;
        this.iva = subtotal * 0.19;
        this.total = subtotal + iva;
        this.items = items;
        this.fechaEmision = LocalDateTime.now();
        this.estado = "GENERADA";
    }

    // Getters (¡incluyendo getClienteId()!)
    public String getId() { return id; }
    public String getPedidoId() { return pedidoId; }
    public String getClienteId() { return clienteId; } // ¡Getter crítico!
    public LocalDateTime getFechaEmision() { return fechaEmision; }
    public double getSubtotal() { return subtotal; }
    public double getIva() { return iva; }
    public double getTotal() { return total; }
    public String getEstado() { return estado; }
    public List<String> getItems() { return items; }

    // Setters y métodos de estado
    public void marcarComoPagada() { this.estado = "PAGADA"; }
    public void anular() { this.estado = "ANULADA"; }
}