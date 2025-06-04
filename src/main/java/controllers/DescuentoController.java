package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Descuento;
import repository.DescuentoRepository;
import java.time.LocalDate;
import java.util.Map;

public class DescuentoController {
    public static void init(Javalin app) {
        app.post("/descuentos", ctx -> {
            Map<String, Object> body = ctx.bodyAsClass(Map.class);
            Descuento descuento = new Descuento(
                    body.get("codigo").toString(),
                    Double.parseDouble(body.get("porcentaje").toString()),
                    LocalDate.parse(body.get("fechaFin").toString())
            );
            DescuentoRepository.save(descuento);
            ctx.status(201).json(descuento);
        });

        app.get("/descuentos/{codigo}", ctx -> {
            Descuento descuento = DescuentoRepository.findByCodigo(ctx.pathParam("codigo"));
            ctx.json(descuento != null ? descuento : ctx.status(404));
        });
    }
}