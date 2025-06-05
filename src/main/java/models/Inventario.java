package models;

public class Inventario {
    private String id;
    private String productoId;
    private int cantidad;
    private String ubicacion;

    public Inventario() {}

    public Inventario(String id, String productoId, int cantidad, String ubicacion) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProductoId() { return productoId; }
    public void setProductoId(String productoId) { this.productoId = productoId; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}