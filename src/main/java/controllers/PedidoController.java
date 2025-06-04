package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Pedido;
import repository.PedidoRepository;
import java.util.List;
import java.util.Map;

public class PedidoController {
    public static void init(Javalin app) {
        app.post("/pedidos", PedidoController::create);
        app.get("/pedidos", PedidoController::getAll);
        app.get("/pedidos/{id}", PedidoController::getById);
        app.put("/pedidos/{id}/estado", PedidoController::updateEstado);
        app.delete("/pedidos/{id}", PedidoController::delete);
    }

    private static void create(Context ctx) {
        try {
            Pedido pedido = ctx.bodyAsClass(Pedido.class);
            PedidoRepository.save(pedido);
            ctx.status(201).json(pedido);
        } catch (Exception e) {
            ctx.status(400).result("Error en los datos del pedido: " + e.getMessage());
        }
    }

    private static void getAll(Context ctx) {
        List<Pedido> pedidos = PedidoRepository.findAll();
        ctx.json(pedidos);
    }

    private static void getById(Context ctx) {
        String id = ctx.pathParam("id");
        Pedido pedido = PedidoRepository.findById(id);
        if (pedido != null) {
            ctx.json(pedido);
        } else {
            ctx.status(404).result("Pedido no encontrado");
        }
    }

    private static void updateEstado(Context ctx) {
        String id = ctx.pathParam("id");
        Pedido pedido = PedidoRepository.findById(id);

        if (pedido == null) {
            ctx.status(404).result("Pedido no encontrado");
            return;
        }

        try {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            String nuevoEstado = (String) body.get("estado"); // Casting explícito aquí

            if (nuevoEstado == null || nuevoEstado.isEmpty()) {
                ctx.status(400).result("El campo 'estado' es requerido");
                return;
            }

            pedido.setEstado(nuevoEstado);
            PedidoRepository.update(pedido);
            ctx.json(pedido);

        } catch (ClassCastException e) {
            ctx.status(400).result("El campo 'estado' debe ser una cadena de texto");
        } catch (Exception e) {
            ctx.status(500).result("Error interno del servidor");
        }
    }

    private static void delete(Context ctx) {
        String id = ctx.pathParam("id");
        boolean deleted = PedidoRepository.delete(id);
        ctx.status(deleted ? 204 : 404);
    }
}