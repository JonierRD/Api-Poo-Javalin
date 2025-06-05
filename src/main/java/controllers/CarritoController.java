package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Carrito;
import repository.CarritoRepository;
import java.util.Map;

public class CarritoController {
    public static void init(Javalin app) {
        // Crear carrito
        app.post("/carritos", ctx -> {
            String usuarioId = ctx.bodyAsClass(Map.class).get("usuarioId").toString();
            Carrito carrito = new Carrito(usuarioId);
            CarritoRepository.save(carrito);
            ctx.status(201).json(carrito);
        });

        // Agregar item al carrito
        app.post("/carritos/{usuarioId}/items", ctx -> {
            String usuarioId = ctx.pathParam("usuarioId");
            Map<String, Object> body = ctx.bodyAsClass(Map.class);

            Carrito carrito = CarritoRepository.findByUsuarioId(usuarioId);
            if (carrito == null) {
                ctx.status(404).result("Carrito no encontrado");
                return;
            }

            String productoId = body.get("productoId").toString();
            int cantidad = Integer.parseInt(body.get("cantidad").toString());
            double precio = Double.parseDouble(body.get("precioUnitario").toString());

            carrito.agregarItem(productoId, cantidad, precio);
            CarritoRepository.save(carrito);
            ctx.json(carrito);
        });

        // Obtener carrito por usuario
        app.get("/carritos/{usuarioId}", ctx -> {
            Carrito carrito = CarritoRepository.findByUsuarioId(ctx.pathParam("usuarioId"));
            if (carrito != null) {
                ctx.json(carrito);
            } else {
                ctx.status(404);
            }
        });
    }
}