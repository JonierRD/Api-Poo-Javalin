package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Pago;
import repository.PagoRepository;
import java.util.Map;

public class PagoController {
    public static void init(Javalin app) {
        // Registrar pago
        app.post("/pagos", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Pago pago = new Pago(
                    body.get("pedidoId").toString(),
                    Double.parseDouble(body.get("monto").toString()),
                    body.get("metodo").toString()
            );
            PagoRepository.save(pago);
            ctx.status(201).json(pago);
        });

        // Consultar pago por pedido
        app.get("/pedidos/{pedidoId}/pago", ctx -> {
            Pago pago = PagoRepository.findByPedidoId(ctx.pathParam("pedidoId"));
            ctx.json(pago != null ? pago : ctx.status(404));
        });
    }
}
