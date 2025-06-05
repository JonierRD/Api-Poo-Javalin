package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Almacen;
import repository.AlmacenRepository;
import java.util.List;

public class AlmacenController {
    private final Javalin app;

    public AlmacenController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/almacenes", this::getAllAlmacenes);
        app.post("/api/almacenes", this::createAlmacen);
        app.get("/api/almacenes/{id}", this::getAlmacenById);
    }

    private void getAllAlmacenes(Context ctx) {
        List<Almacen> almacenes = AlmacenRepository.findAll();
        ctx.json(almacenes);
    }

    private void createAlmacen(Context ctx) {
        Almacen almacen = ctx.bodyAsClass(Almacen.class);
        AlmacenRepository.save(almacen);
        ctx.status(201).json(almacen);
    }

    private void getAlmacenById(Context ctx) {
        String id = ctx.pathParam("id");
        Almacen almacen = AlmacenRepository.findById(id);
        ctx.json(almacen);
    }
}