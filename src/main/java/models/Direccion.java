package models;

public class Direccion {
    private String id;
    private String usuarioId;
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private boolean esPrincipal;

    public Direccion(String usuarioId, String calle, String ciudad, String codigoPostal) {
        this.usuarioId = usuarioId;
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.esPrincipal = false;
    }

    // Getters
    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }
    public boolean isEsPrincipal() { return esPrincipal; }

    // Setters
    public void marcarComoPrincipal() { this.esPrincipal = true; }
    public void actualizarDatos(String calle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }
}