package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Almacen;
import repository.AlmacenRepository;
import java.util.Map;

public class AlmacenController {
    public static void init(Javalin app) {
        // Registrar almacén
        app.post("/almacenes", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Almacen almacen = new Almacen(
                    body.get("nombre").toString(),
                    body.get("ubicacion").toString(),
                    Double.parseDouble(body.get("capacidadM2").toString()),
                    body.get("tipo").toString()
            );
            AlmacenRepository.save(almacen);
            ctx.status(201).json(almacen);
        });

        // Buscar por tipo
        app.get("/almacenes/tipo/{tipo}", ctx -> {
            ctx.json(AlmacenRepository.findByTipo(ctx.pathParam("tipo")));
        });
    }
}