
package repository;

import models.Rol;
import java.util.*;

public class RolRepository {
    private static final Map<String, Rol> roles = new HashMap<>();
    private static final Map<String, String> rolesPorNombre = new HashMap<>();

    public static void save(Rol rol) {
        roles.put(rol.getId(), rol);
        rolesPorNombre.put(rol.getNombre(), rol.getId());
    }

    public static Rol findByNombre(String nombre) {
        String id = rolesPorNombre.get(nombre);
        return id != null ? roles.get(id) : null;
    }
}