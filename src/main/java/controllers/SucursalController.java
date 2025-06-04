
package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Sucursal;
import repository.SucursalRepository;
import java.util.Map;

public class SucursalController {
    public static void init(Javalin app) {
        app.post("/sucursales", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Sucursal sucursal = new Sucursal(
                    body.get("nombre"),
                    body.get("direccion"),
                    body.get("telefono"),
                    body.get("horario")
            );
            SucursalRepository.save(sucursal);
            ctx.status(201).json(sucursal);
        });

        app.get("/sucursales/{nombre}", ctx -> {
            Sucursal sucursal = SucursalRepository.findByNombre(ctx.pathParam("nombre"));
            ctx.json(sucursal != null ? sucursal : ctx.status(404));
        });
    }
}