package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Descuento;
import repository.DescuentoRepository;
import java.util.List;

public class DescuentoController {
    private final Javalin app;

    public DescuentoController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/descuentos", this::getAllDescuentos);
        app.post("/api/descuentos", this::createDescuento);
    }

    private void getAllDescuentos(Context ctx) {
        List<Descuento> descuentos = DescuentoRepository.findAll();
        ctx.json(descuentos);
    }

    private void createDescuento(Context ctx) {
        Descuento descuento = ctx.bodyAsClass(Descuento.class);
        DescuentoRepository.save(descuento);
        ctx.status(201).json(descuento);
    }
}