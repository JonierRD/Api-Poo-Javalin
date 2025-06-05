package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Transporte;
import repository.TransporteRepository;
import java.util.List;

public class TransporteController {
    private final Javalin app;

    public TransporteController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/transportes", this::getAllTransportes);
        app.post("/api/transportes", this::createTransporte);
    }

    private void getAllTransportes(Context ctx) {
        List<Transporte> transportes = TransporteRepository.findAll();
        ctx.json(transportes);
    }

    private void createTransporte(Context ctx) {
        Transporte transporte = ctx.bodyAsClass(Transporte.class);
        TransporteRepository.save(transporte);
        ctx.status(201).json(transporte);
    }
}