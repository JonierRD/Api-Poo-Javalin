package models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Logistica {
    private String id;
    private String pedidoId;
    private String transportista;
    private String estado; // "PREPARACION", "EN_TRANSITO", "ENTREGADO"
    private LocalDateTime fechaEntrega;
    private String direccionEntrega;

    public Logistica(String pedidoId, String transportista, String direccionEntrega) {
        this.id = "LOG-" + UUID.randomUUID().toString();
        this.pedidoId = pedidoId;
        this.transportista = transportista;
        this.direccionEntrega = direccionEntrega;
        this.estado = "PREPARACION";
    }

    // Getters
    public String getId() { return id; }
    public String getPedidoId() { return pedidoId; }
    public String getTransportista() { return transportista; }
    public String getEstado() { return estado; }
    public String getDireccionEntrega() { return direccionEntrega; }

    // Métodos de estado
    public void iniciarEnvio() {
        this.estado = "EN_TRANSITO";
    }
    public void marcarEntregado() {
        this.estado = "ENTREGADO";
        this.fechaEntrega = LocalDateTime.now();
    }
}
