package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Sucursal;
import repository.SucursalRepository;
import java.util.List;

public class SucursalController {
    private final Javalin app;

    public SucursalController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/sucursales", this::getAllSucursales);
        app.post("/api/sucursales", this::createSucursal);
    }

    private void getAllSucursales(Context ctx) {
        List<Sucursal> sucursales = SucursalRepository.findAll();
        ctx.json(sucursales);
    }

    private void createSucursal(Context ctx) {
        Sucursal sucursal = ctx.bodyAsClass(Sucursal.class);
        SucursalRepository.save(sucursal);
        ctx.status(201).json(sucursal);
    }
}