package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Rol;
import repository.RolRepository;
import java.util.Map;
import java.util.List; // <-- Añade este import

public class RolController {
    public static void init(Javalin app) {
        // Crear rol
        app.post("/roles", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Rol rol = new Rol(
                    body.get("nombre").toString(),
                    ((List<String>) body.get("permisos")).toArray(new String[0]) // <-- Ahora List está reconocido
            );
            RolRepository.save(rol);
            ctx.status(201).json(rol);
        });

        // Verificar permiso
        app.get("/roles/{nombre}/permisos/{permiso}", ctx -> {
            Rol rol = RolRepository.findByNombre(ctx.pathParam("nombre"));
            boolean tienePermiso = rol != null &&
                    rol.tienePermiso(ctx.pathParam("permiso"));
            ctx.json(Map.of("tienePermiso", tienePermiso));
        });
    }
}