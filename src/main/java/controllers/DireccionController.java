package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Direccion;
import repository.DireccionRepository;
import java.util.Map;

public class DireccionController {
    public static void init(Javalin app) {
        // Registrar dirección
        app.post("/usuarios/{usuarioId}/direcciones", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Direccion direccion = new Direccion(
                    ctx.pathParam("usuarioId"),
                    body.get("calle"),
                    body.get("ciudad"),
                    body.get("codigoPostal")
            );
            DireccionRepository.save(direccion);
            ctx.status(201).json(direccion);
        });

        // Obtener direcciones de usuario
        app.get("/usuarios/{usuarioId}/direcciones", ctx -> {
            ctx.json(DireccionRepository.findByUsuarioId(ctx.pathParam("usuarioId")));
        });
    }
}