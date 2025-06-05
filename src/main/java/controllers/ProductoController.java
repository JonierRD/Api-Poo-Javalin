package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Producto;
import repository.ProductoRepository;
import java.util.List;

public class ProductoController {
    private final Javalin app;

    public ProductoController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/productos", this::getAllProductos);
        app.post("/api/productos", this::createProducto);
    }

    private void getAllProductos(Context ctx) {
        List<Producto> productos = ProductoRepository.findAll();
        ctx.json(productos);
    }

    private void createProducto(Context ctx) {
        Producto producto = ctx.bodyAsClass(Producto.class);
        ProductoRepository.save(producto);
        ctx.status(201).json(producto);
    }
}