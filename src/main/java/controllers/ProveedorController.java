package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Proveedor;
import repository.ProveedorRepository;
import java.util.List;

public class ProveedorController {
    private final Javalin app;

    public ProveedorController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/proveedores", this::getAllProveedores);
        app.post("/api/proveedores", this::createProveedor);
    }

    private void getAllProveedores(Context ctx) {
        List<Proveedor> proveedores = ProveedorRepository.findAll();
        ctx.json(proveedores);
    }

    private void createProveedor(Context ctx) {
        Proveedor proveedor = ctx.bodyAsClass(Proveedor.class);
        ProveedorRepository.save(proveedor);
        ctx.status(201).json(proveedor);
    }
}