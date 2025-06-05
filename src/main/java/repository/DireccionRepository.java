package repository;

import models.Direccion;
import java.util.*;

public class DireccionRepository {
    private static final Map<String, Direccion> direcciones = new HashMap<>();

    public static List<Direccion> findAll() {
        return new ArrayList<>(direcciones.values());
    }

    public static Direccion findById(String id) {
        return direcciones.get(id);
    }

    public static void save(Direccion direccion) {
        direcciones.put(direccion.getId(), direccion);
    }
}