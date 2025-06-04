package models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Resena {
    private String id;
    private String productoId;
    private String usuarioId;
    private int calificacion; // 1-5
    private String comentario;
    private LocalDateTime fecha;

    public Resena(String productoId, String usuarioId, int calificacion, String comentario) {
        this.id = "RES-" + UUID.randomUUID().toString();
        this.productoId = productoId;
        this.usuarioId = usuarioId;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = LocalDateTime.now();
    }

    // Getters
    public String getId() { return id; }
    public String getProductoId() { return productoId; }
    public String getUsuarioId() { return usuarioId; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }
    public LocalDateTime getFecha() { return fecha; }

    // Validación
    public boolean esValida() {
        return calificacion >= 1 && calificacion <= 5 &&
                comentario != null && !comentario.trim().isEmpty();
    }
}
