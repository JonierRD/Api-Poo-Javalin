package controllers;

import io.javalin.http.Context;
import models.Usuario;
import repositories.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioController {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void createUsuario(Context ctx) {
        try {
            Usuario usuario = ctx.bodyAsClass(Usuario.class);
            Usuario nuevoUsuario = UsuarioRepository.addUsuario(usuario);
            ctx.status(201).json(nuevoUsuario);
        } catch (Exception e) {
            ctx.status(400).result("Error en los datos del usuario");
        }
    }

    public static void getAllUsuarios(Context ctx) {
        ctx.json(UsuarioRepository.getAllUsuarios());
    }

    public static void getUsuarioById(Context ctx) {
        String id = ctx.pathParam("id");
        UsuarioRepository.getUsuarioById(id)
                .ifPresentOrElse(
                        usuario -> ctx.json(usuario),
                        () -> ctx.status(404).result("Usuario no encontrado")
                );
    }

    public static void updateUsuario(Context ctx) {
        String id = ctx.pathParam("id");
        Usuario updatedUsuario = ctx.bodyAsClass(Usuario.class);
        if (UsuarioRepository.updateUsuario(id, updatedUsuario)) {
            ctx.status(200).json(updatedUsuario);
        } else {
            ctx.status(404).result("Usuario no encontrado");
        }
    }

    public static void deleteUsuario(Context ctx) {
        String id = ctx.pathParam("id");
        if (UsuarioRepository.deleteUsuario(id)) {
            ctx.status(204);
        } else {
            ctx.status(404).result("Usuario no encontrado");
        }
    }
}