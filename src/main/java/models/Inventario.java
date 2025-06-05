package models;

public class Inventario {
    private String id;
    private String productoId;
    private String sucursalId;
    private int cantidad;
    private int stockMinimo;

    public Inventario(String productoId, String sucursalId, int cantidad, int stockMinimo) {
        this.productoId = productoId;
        this.sucursalId = sucursalId;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
    }

    // Getters
    public String getProductoId() { return productoId; }
    public String getSucursalId() { return sucursalId; }
    public int getCantidad() { return cantidad; }
    public int getStockMinimo() { return stockMinimo; }

    // Métodos de gestión
    public void agregarStock(int cantidad) {
        this.cantidad += cantidad;
    }

    public boolean necesitaReabastecimiento() {
        return cantidad < stockMinimo;
    }
}
