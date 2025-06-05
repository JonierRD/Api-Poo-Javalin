package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Usuario;
import repository.UsuarioRepository;
import java.util.List;

public class UsuarioController {
    private final Javalin app;

    public UsuarioController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/usuarios", this::getAllUsuarios);
        app.post("/api/usuarios", this::createUsuario);
    }

    private void getAllUsuarios(Context ctx) {
        List<Usuario> usuarios = UsuarioRepository.findAll();
        ctx.json(usuarios);
    }

    private void createUsuario(Context ctx) {
        Usuario usuario = ctx.bodyAsClass(Usuario.class);
        UsuarioRepository.save(usuario);
        ctx.status(201).json(usuario);
    }
}