package repositories;

import models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static int nextId = 1;

    public static Usuario addUsuario(Usuario usuario) {
        usuario.setId(String.valueOf(nextId++));
        usuarios.add(usuario);
        return usuario;
    }

    public static List<Usuario> getAllUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public static Optional<Usuario> getUsuarioById(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public static boolean updateUsuario(String id, Usuario updatedUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                updatedUsuario.setId(id);
                usuarios.set(i, updatedUsuario);
                return true;
            }
        }
        return false;
    }

    public static boolean deleteUsuario(String id) {
        return usuarios.removeIf(u -> u.getId().equals(id));
    }
}