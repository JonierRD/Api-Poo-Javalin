package models;

public class Almacen {
    private String id;
    private String nombre;
    private String ubicacion;
    private double capacidadM2;
    private String tipo; // "PRINCIPAL", "SECUNDARIO", "REFRIGERADO"

    public Almacen(String nombre, String ubicacion, double capacidadM2, String tipo) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadM2 = capacidadM2;
        this.tipo = tipo;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public double getCapacidadM2() { return capacidadM2; }
    public String getTipo() { return tipo; }

    // Métodos de capacidad
    public boolean puedeAlmacenar(double espacioRequerido) {
        return espacioRequerido <= capacidadM2;
    }
}