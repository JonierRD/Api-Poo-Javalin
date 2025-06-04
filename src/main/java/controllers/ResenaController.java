package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Resena;
import repository.ResenaRepository;
import java.util.Map;

public class ResenaController {
    public static void init(Javalin app) {
        // Crear reseña
        app.post("/productos/{productoId}/resenas", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Resena resena = new Resena(
                    ctx.pathParam("productoId"),
                    body.get("usuarioId").toString(),
                    Integer.parseInt(body.get("calificacion").toString()),
                    body.get("comentario").toString()
            );
            ResenaRepository.save(resena);
            ctx.status(201).json(resena);
        });

        // Obtener reseñas de producto
        app.get("/productos/{productoId}/resenas", ctx -> {
            ctx.json(ResenaRepository.findByProductoId(ctx.pathParam("productoId")));
        });

        // Obtener promedio de calificaciones
        app.get("/productos/{productoId}/calificacion-promedio", ctx -> {
            double promedio = ResenaRepository.getPromedioCalificaciones(ctx.pathParam("productoId"));
            ctx.json(Map.of("promedio", promedio));
        });
    }
}