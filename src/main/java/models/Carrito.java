package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Carrito {
    private String id;
    private String usuarioId;
    private List<ItemCarrito> items;
    private double total;

    public Carrito(String usuarioId) {
        this.id = UUID.randomUUID().toString();
        this.usuarioId = usuarioId;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    // Clase interna para items del carrito
    public static class ItemCarrito {
        private String productoId;
        private int cantidad;
        private double precioUnitario;

        public ItemCarrito(String productoId, int cantidad, double precioUnitario) {
            this.productoId = productoId;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
        }

        // Getters
        public String getProductoId() { return productoId; }
        public int getCantidad() { return cantidad; }
        public double getPrecioUnitario() { return precioUnitario; }
    }

    // Métodos principales
    public void agregarItem(String productoId, int cantidad, double precio) {
        items.add(new ItemCarrito(productoId, cantidad, precio));
        calcularTotal();
    }

    public void eliminarItem(String productoId) {
        items.removeIf(item -> item.getProductoId().equals(productoId));
        calcularTotal();
    }

    private void calcularTotal() {
        this.total = items.stream()
                .mapToDouble(item -> item.getPrecioUnitario() * item.getCantidad())
                .sum();
    }

    // Getters
    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public List<ItemCarrito> getItems() { return items; }
    public double getTotal() { return total; }
}