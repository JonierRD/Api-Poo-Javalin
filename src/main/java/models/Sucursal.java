package models;

public class Sucursal {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;

    public Sucursal(String nombre, String direccion, String telefono, String horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getHorario() { return horario; }

    // Setters
    public void actualizarHorario(String nuevoHorario) {
        this.horario = nuevoHorario;
    }
}
