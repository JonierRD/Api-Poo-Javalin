package models;

import java.time.LocalDate;

public class Empleado {
    private String id;
    private String nombre;
    private String cargo; // "GERENTE", "VENDEDOR", "REPARTIDOR"
    private LocalDate fechaContratacion;
    private double salario;
    private String sucursalId; // Relación con Sucursal

    public Empleado(String nombre, String cargo, double salario, String sucursalId) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.sucursalId = sucursalId;
        this.fechaContratacion = LocalDate.now();
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCargo() { return cargo; }
    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public double getSalario() { return salario; }
    public String getSucursalId() { return sucursalId; }

    // Métodos de negocio
    public void aumentarSalario(double porcentaje) {
        this.salario += this.salario * (porcentaje / 100);
    }

    public void transferirSucursal(String nuevaSucursalId) {
        this.sucursalId = nuevaSucursalId;
    }
}