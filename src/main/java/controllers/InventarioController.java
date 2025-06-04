package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Inventario;
import repository.InventarioRepository;
import java.util.Map;

public class InventarioController {
    public static void init(Javalin app) {
        // Registrar item en inventario
        app.post("/inventario", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Inventario inventario = new Inventario(
                    body.get("productoId").toString(),
                    body.get("sucursalId").toString(),
                    Integer.parseInt(body.get("cantidad").toString()),
                    Integer.parseInt(body.get("stockMinimo").toString())
            );
            InventarioRepository.save(inventario);
            ctx.status(201).json(inventario);
        });

        // Consultar stock por producto y sucursal
        app.get("/inventario/{productoId}/{sucursalId}", ctx -> {
            Inventario inventario = InventarioRepository.findByProductoYSucursal(
                    ctx.pathParam("productoId"),
                    ctx.pathParam("sucursalId")
            );
            ctx.json(inventario != null ? inventario : ctx.status(404));
        });
    }
}