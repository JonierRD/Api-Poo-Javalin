package models;

import java.time.LocalDateTime;

public class Logistica {
    private String id;
    private String pedidoId;
    private String transporteId;
    private LocalDateTime fechaEntrega;
    private String estado;

    public Logistica() {}

    public Logistica(String id, String pedidoId, String transporteId, LocalDateTime fechaEntrega, String estado) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.transporteId = transporteId;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPedidoId() { return pedidoId; }
    public void setPedidoId(String pedidoId) { this.pedidoId = pedidoId; }
    public String getTransporteId() { return transporteId; }
    public void setTransporteId(String transporteId) { this.transporteId = transporteId; }
    public LocalDateTime getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDateTime fechaEntrega) { this.fechaEntrega = fechaEntrega; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
