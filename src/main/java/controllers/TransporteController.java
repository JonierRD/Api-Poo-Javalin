package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Transporte;
import repository.TransporteRepository;
import java.util.Map;

public class TransporteController {
    public static void init(Javalin app) {
        // Registrar transporte
        app.post("/transportes", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Transporte transporte = new Transporte(
                    body.get("placa").toString(),
                    body.get("tipo").toString(),
                    Double.parseDouble(body.get("capacidadKg").toString())
            );
            TransporteRepository.save(transporte);
            ctx.status(201).json(transporte);
        });

        // Listar transportes disponibles
        app.get("/transportes/disponibles", ctx -> {
            ctx.json(TransporteRepository.findDisponibles());
        });
    }
}
