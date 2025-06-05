package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Logistica;
import repository.LogisticaRepository;
import java.util.List;

public class LogisticaController {
    private final Javalin app;

    public LogisticaController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/logistica", this::getAllLogistica);
        app.post("/api/logistica", this::createLogistica);
    }

    private void getAllLogistica(Context ctx) {
        List<Logistica> logistica = LogisticaRepository.findAll();
        ctx.json(logistica);
    }

    private void createLogistica(Context ctx) {
        Logistica logistica = ctx.bodyAsClass(Logistica.class);
        LogisticaRepository.save(logistica);
        ctx.status(201).json(logistica);
    }
}