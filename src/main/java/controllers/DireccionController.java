package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Direccion;
import repository.DireccionRepository;
import java.util.List;

public class DireccionController {
    private final Javalin app;

    public DireccionController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/direcciones", this::getAllDirecciones);
        app.post("/api/direcciones", this::createDireccion);
    }

    private void getAllDirecciones(Context ctx) {
        List<Direccion> direcciones = DireccionRepository.findAll();
        ctx.json(direcciones);
    }

    private void createDireccion(Context ctx) {
        Direccion direccion = ctx.bodyAsClass(Direccion.class);
        DireccionRepository.save(direccion);
        ctx.status(201).json(direccion);
    }
}