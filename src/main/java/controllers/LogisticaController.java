package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Logistica;
import repository.LogisticaRepository;
import java.util.Map;

public class LogisticaController {
    public static void init(Javalin app) {
        // Programar envío
        app.post("/logistica", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Logistica logistica = new Logistica(
                    body.get("pedidoId"),
                    body.get("transportista"),
                    body.get("direccionEntrega")
            );
            LogisticaRepository.save(logistica);
            ctx.status(201).json(logistica);
        });

        // Actualizar estado
        app.put("/logistica/{pedidoId}/estado", ctx -> {
            Logistica logistica = LogisticaRepository.findByPedidoId(ctx.pathParam("pedidoId"));
            if (logistica == null) {
                ctx.status(404);
                return;
            }
            String accion = ctx.bodyAsClass(Map.class).get("accion").toString();
            switch (accion) {
                case "iniciar": logistica.iniciarEnvio(); break;
                case "entregar": logistica.marcarEntregado(); break;
            }
            LogisticaRepository.save(logistica);
            ctx.json(logistica);
        });
    }
}
