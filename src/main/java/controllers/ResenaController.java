package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Resena;
import repository.ResenaRepository;
import java.util.List;

public class ResenaController {
    private final Javalin app;

    public ResenaController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/resenas", this::getAllResenas);
        app.post("/api/resenas", this::createResena);
    }

    private void getAllResenas(Context ctx) {
        List<Resena> resenas = ResenaRepository.findAll();
        ctx.json(resenas);
    }

    private void createResena(Context ctx) {
        Resena resena = ctx.bodyAsClass(Resena.class);
        ResenaRepository.save(resena);
        ctx.status(201).json(resena);
    }
}