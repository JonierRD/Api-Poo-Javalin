package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Factura;
import repository.FacturaRepository;
import java.util.List;
import java.util.Map;

public class FacturaController {
    public static void init(Javalin app) {
        // Generar factura
        app.post("/facturas", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Factura factura = new Factura(
                    body.get("pedidoId").toString(),
                    body.get("clienteId").toString(),
                    Double.parseDouble(body.get("subtotal").toString()),
                    (List<String>) body.get("items")
            );
            FacturaRepository.save(factura);
            ctx.status(201).json(factura);
        });

        // Obtener facturas por cliente
        app.get("/clientes/{clienteId}/facturas", ctx -> {
            ctx.json(FacturaRepository.findByClienteId(ctx.pathParam("clienteId")));
        });
    }
}