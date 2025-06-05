package repository;

import models.Rol;
import java.util.*;

public class RolRepository {
    private static final Map<String, Rol> roles = new HashMap<>();

    public static List<Rol> findAll() {
        return new ArrayList<>(roles.values());
    }

    public static Rol findById(String id) {
        return roles.get(id);
    }

    public static void save(Rol rol) {
        roles.put(rol.getId(), rol);
    }
}