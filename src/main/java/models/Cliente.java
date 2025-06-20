package models;

public class Cliente {
    private String id;
    private String nombre;
    private String email;
    private String direccion;

    public Cliente() {}

    public Cliente(String id, String nombre, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}