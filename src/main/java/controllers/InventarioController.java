package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Inventario;
import repository.InventarioRepository;
import java.util.List;

public class InventarioController {
    private final Javalin app;

    public InventarioController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/inventario", this::getAllInventario);
        app.post("/api/inventario", this::createInventario);
    }

    private void getAllInventario(Context ctx) {
        List<Inventario> inventario = InventarioRepository.findAll();
        ctx.json(inventario);
    }

    private void createInventario(Context ctx) {
        Inventario item = ctx.bodyAsClass(Inventario.class);
        InventarioRepository.save(item);
        ctx.status(201).json(item);
    }
}