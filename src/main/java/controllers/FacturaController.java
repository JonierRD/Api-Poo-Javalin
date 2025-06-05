package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Factura;
import repository.FacturaRepository;
import java.util.List;

public class FacturaController {
    private final Javalin app;

    public FacturaController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/facturas", this::getAllFacturas);
        app.post("/api/facturas", this::createFactura);
    }

    private void getAllFacturas(Context ctx) {
        List<Factura> facturas = FacturaRepository.findAll();
        ctx.json(facturas);
    }

    private void createFactura(Context ctx) {
        Factura factura = ctx.bodyAsClass(Factura.class);
        FacturaRepository.save(factura);
        ctx.status(201).json(factura);
    }
}