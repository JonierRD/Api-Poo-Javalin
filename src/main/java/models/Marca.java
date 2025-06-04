package models;

public class Marca {
    private String id;
    private String nombre;
    private String paisOrigen;
    private String sitioWeb;

    public Marca(String nombre, String paisOrigen, String sitioWeb) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.sitioWeb = sitioWeb;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPaisOrigen() { return paisOrigen; }
    public String getSitioWeb() { return sitioWeb; }

    // Setters
    public void actualizarInfo(String paisOrigen, String sitioWeb) {
        this.paisOrigen = paisOrigen;
        this.sitioWeb = sitioWeb;
    }
}
