
package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Empleado;
import repository.EmpleadoRepository;
import java.util.Map;

public class EmpleadoController {
    public static void init(Javalin app) {
        // Registrar empleado
        app.post("/empleados", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Empleado empleado = new Empleado(
                    body.get("nombre").toString(),
                    body.get("cargo").toString(),
                    Double.parseDouble(body.get("salario").toString()),
                    body.get("sucursalId").toString()
            );
            EmpleadoRepository.save(empleado);
            ctx.status(201).json(empleado);
        });

        // Listar por sucursal
        app.get("/sucursales/{sucursalId}/empleados", ctx -> {
            ctx.json(EmpleadoRepository.findBySucursal(ctx.pathParam("sucursalId")));
        });
    }
}