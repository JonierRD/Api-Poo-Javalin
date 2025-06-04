package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Marca;
import repository.MarcaRepository;
import java.util.Map;

public class MarcaController {
    public static void init(Javalin app) {
        app.post("/marcas", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Marca marca = new Marca(
                    body.get("nombre"),
                    body.get("paisOrigen"),
                    body.get("sitioWeb")
            );
            MarcaRepository.save(marca);
            ctx.status(201).json(marca);
        });

        app.get("/marcas/{nombre}", ctx -> {
            Marca marca = MarcaRepository.findByNombre(ctx.pathParam("nombre"));
            ctx.json(marca != null ? marca : ctx.status(404));
        });
    }
}
