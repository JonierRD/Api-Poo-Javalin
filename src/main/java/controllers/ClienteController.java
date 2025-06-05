package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Cliente;
import repository.ClienteRepository;
import java.util.Map;

public class ClienteController {
    public static void init(Javalin app) {
        // Registrar cliente
        app.post("/clientes", ctx -> {
            Map<String, String> body = ctx.bodyAsClass(Map.class);
            Cliente cliente = new Cliente(
                    body.get("nombre"),
                    body.get("email"),
                    body.get("telefono"),
                    body.get("tipo")
            );
            ClienteRepository.save(cliente);
            ctx.status(201).json(cliente);
        });

        // Buscar por email
        app.get("/clientes/email/{email}", ctx -> {
            Cliente cliente = ClienteRepository.findByEmail(ctx.pathParam("email"));
            ctx.json(cliente != null ? cliente : ctx.status(404));
        });
    }
}