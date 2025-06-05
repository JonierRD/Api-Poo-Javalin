package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Rol;
import repository.RolRepository;
import java.util.List;

public class RolController {
    private final Javalin app;

    public RolController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/roles", this::getAllRoles);
        app.post("/api/roles", this::createRol);
    }

    private void getAllRoles(Context ctx) {
        List<Rol> roles = RolRepository.findAll();
        ctx.json(roles);
    }

    private void createRol(Context ctx) {
        Rol rol = ctx.bodyAsClass(Rol.class);
        RolRepository.save(rol);
        ctx.status(201).json(rol);
    }
}