package repository;

import models.Almacen;
import java.util.*;

public class AlmacenRepository {
    private static final Map<String, Almacen> almacenes = new HashMap<>();
    private static final Map<String, String> almacenesPorNombre = new HashMap<>();

    public static void save(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        almacenesPorNombre.put(almacen.getNombre(), almacen.getId());
    }

    public static Almacen findByNombre(String nombre) {
        String id = almacenesPorNombre.get(nombre);
        return id != null ? almacenes.get(id) : null;
    }

    public static List<Almacen> findByTipo(String tipo) {
        return almacenes.values().stream()
                .filter(a -> a.getTipo().equals(tipo))
                .toList();
    }
}