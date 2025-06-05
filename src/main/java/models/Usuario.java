package models;

public class Usuario {
    private String id;
    private String username;
    private String password;
    private String rolId;
    private String email;

    public Usuario() {}

    public Usuario(String id, String username, String password, String rolId, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rolId = rolId;
        this.email = email;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRolId() { return rolId; }
    public void setRolId(String rolId) { this.rolId = rolId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}