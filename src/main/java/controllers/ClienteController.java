package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Cliente;
import repository.ClienteRepository;
import java.util.List;

public class ClienteController {
    private final Javalin app;

    public ClienteController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/clientes", this::getAllClientes);
        app.post("/api/clientes", this::createCliente);
    }

    private void getAllClientes(Context ctx) {
        List<Cliente> clientes = ClienteRepository.findAll();
        ctx.json(clientes);
    }

    private void createCliente(Context ctx) {
        Cliente cliente = ctx.bodyAsClass(Cliente.class);
        ClienteRepository.save(cliente);
        ctx.status(201).json(cliente);
    }
}