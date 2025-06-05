package models;

public class Transporte {
    private String id;
    private String placa;
    private String tipo; // "CAMION", "FURGON", "MOTOCICLETA"
    private double capacidadKg;
    private boolean disponible;

    public Transporte(String placa, String tipo, double capacidadKg) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidadKg = capacidadKg;
        this.disponible = true;
    }

    // Getters
    public String getId() { return id; }
    public String getPlaca() { return placa; }
    public String getTipo() { return tipo; }
    public double getCapacidadKg() { return capacidadKg; }
    public boolean isDisponible() { return disponible; }

    // Métodos de estado
    public void reservar() { this.disponible = false; }
    public void liberar() { this.disponible = true; }
}