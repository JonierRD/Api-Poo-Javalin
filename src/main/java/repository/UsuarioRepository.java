package repository;

import models.Usuario;
import java.util.*;

public class UsuarioRepository {
    private static final Map<String, Usuario> usuarios = new HashMap<>();

    public static List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public static Usuario findById(String id) {
        return usuarios.get(id);
    }

    public static void save(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }
}