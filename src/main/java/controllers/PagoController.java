package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Pago;
import repository.PagoRepository;
import java.util.List;

public class PagoController {
    private final Javalin app;

    public PagoController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/pagos", this::getAllPagos);
        app.post("/api/pagos", this::createPago);
    }

    private void getAllPagos(Context ctx) {
        List<Pago> pagos = PagoRepository.findAll();
        ctx.json(pagos);
    }

    private void createPago(Context ctx) {
        Pago pago = ctx.bodyAsClass(Pago.class);
        PagoRepository.save(pago);
        ctx.status(201).json(pago);
    }
}
