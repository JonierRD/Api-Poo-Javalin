package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Pedido;
import repository.PedidoRepository;
import java.util.List;

public class PedidoController {
    private final Javalin app;

    public PedidoController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/pedidos", this::getAllPedidos);
        app.post("/api/pedidos", this::createPedido);
    }

    private void getAllPedidos(Context ctx) {
        List<Pedido> pedidos = PedidoRepository.findAll();
        ctx.json(pedidos);
    }

    private void createPedido(Context ctx) {
        Pedido pedido = ctx.bodyAsClass(Pedido.class);
        PedidoRepository.save(pedido);
        ctx.status(201).json(pedido);
    }
}