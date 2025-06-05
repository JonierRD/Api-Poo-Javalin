package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Proveedor;
import repository.ProveedorRepository;
import java.util.Map;

public class ProveedorController {
    public static void init(Javalin app) {
        // Registrar proveedor
        app.post("/proveedores", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Proveedor proveedor = new Proveedor(
                    body.get("nombre"),
                    body.get("contacto"),
                    body.get("direccion")
            );
            ProveedorRepository.save(proveedor);
            ctx.status(201).json(proveedor);
        });

        // Buscar por nombre
        app.get("/proveedores/{nombre}", ctx -> {
            Proveedor proveedor = ProveedorRepository.findByNombre(ctx.pathParam("nombre"));
            ctx.json(proveedor != null ? proveedor : ctx.status(404));
        });
    }
}
