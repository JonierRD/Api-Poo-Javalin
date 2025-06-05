package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Carrito;
import repository.CarritoRepository;
import java.util.List;

public class CarritoController {
    private final Javalin app;

    public CarritoController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/carritos", this::getAllCarritos);
        app.post("/api/carritos", this::createCarrito);
    }

    private void getAllCarritos(Context ctx) {
        List<Carrito> carritos = CarritoRepository.findAll();
        ctx.json(carritos);
    }

    private void createCarrito(Context ctx) {
        Carrito carrito = ctx.bodyAsClass(Carrito.class);
        CarritoRepository.save(carrito);
        ctx.status(201).json(carrito);
    }
}