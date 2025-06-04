package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Categoria;
import repository.CategoriaRepository;
import java.util.Map;

public class CategoriaController {
    public static void init(Javalin app) {
        // Crear categoría
        app.post("/categorias", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Categoria categoria = new Categoria(
                    body.get("nombre"),
                    body.get("descripcion")
            );
            CategoriaRepository.save(categoria);
            ctx.status(201).json(categoria);
        });

        // Buscar por nombre
        app.get("/categorias/{nombre}", ctx -> {
            Categoria categoria = CategoriaRepository.findByNombre(ctx.pathParam("nombre"));
            ctx.json(categoria != null ? categoria : ctx.status(404));
        });
    }
}