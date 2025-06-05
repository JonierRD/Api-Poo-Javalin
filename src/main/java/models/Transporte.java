package models;

public class Transporte {
    private String id;
    private String tipo;
    private String placa;
    private double capacidadKg;

    public Transporte() {}

    public Transporte(String id, String tipo, String placa, double capacidadKg) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
        this.capacidadKg = capacidadKg;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public double getCapacidadKg() { return capacidadKg; }
    public void setCapacidadKg(double capacidadKg) { this.capacidadKg = capacidadKg; }
}