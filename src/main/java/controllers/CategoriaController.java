package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Categoria;
import repository.CategoriaRepository;
import java.util.List;

public class CategoriaController {
    private final Javalin app;

    public CategoriaController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/categorias", this::getAllCategorias);
        app.post("/api/categorias", this::createCategoria);
    }

    private void getAllCategorias(Context ctx) {
        List<Categoria> categorias = CategoriaRepository.findAll();
        ctx.json(categorias);
    }

    private void createCategoria(Context ctx) {
        Categoria categoria = ctx.bodyAsClass(Categoria.class);
        CategoriaRepository.save(categoria);
        ctx.status(201).json(categoria);
    }
}