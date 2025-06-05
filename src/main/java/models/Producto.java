package models;

public class Producto {
    private String id;
    private String nombre;
    private String categoriaId;
    private double precio;
    private int stock;

    public Producto() {}

    public Producto(String id, String nombre, String categoriaId, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoriaId = categoriaId;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCategoriaId() { return categoriaId; }
    public void setCategoriaId(String categoriaId) { this.categoriaId = categoriaId; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}