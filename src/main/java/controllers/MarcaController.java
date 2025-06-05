package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Marca;
import repository.MarcaRepository;
import java.util.List;

public class MarcaController {
    private final Javalin app;

    public MarcaController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/marcas", this::getAllMarcas);
        app.post("/api/marcas", this::createMarca);
    }

    private void getAllMarcas(Context ctx) {
        List<Marca> marcas = MarcaRepository.findAll();
        ctx.json(marcas);
    }

    private void createMarca(Context ctx) {
        Marca marca = ctx.bodyAsClass(Marca.class);
        MarcaRepository.save(marca);
        ctx.status(201).json(marca);
    }
}