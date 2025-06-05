package models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Pago {
    private String id;
    private String pedidoId;
    private double monto;
    private String metodo; // "TARJETA", "EFECTIVO", "TRANSFERENCIA"
    private LocalDateTime fecha;
    private String estado; // "PENDIENTE", "COMPLETADO", "RECHAZADO"

    public Pago(String pedidoId, double monto, String metodo) {
        this.id = "PAG-" + UUID.randomUUID().toString();
        this.pedidoId = pedidoId;
        this.monto = monto;
        this.metodo = metodo;
        this.fecha = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }

    // Getters
    public String getId() { return id; }
    public String getPedidoId() { return pedidoId; }
    public double getMonto() { return monto; }
    public String getMetodo() { return metodo; }
    public LocalDateTime getFecha() { return fecha; }
    public String getEstado() { return estado; }

    // Métodos de estado
    public void marcarComoCompletado() { this.estado = "COMPLETADO"; }
    public void rechazar() { this.estado = "RECHAZADO"; }
}