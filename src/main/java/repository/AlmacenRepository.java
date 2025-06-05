package repository;

import models.Almacen;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AlmacenRepository {
    private static final Map<String, Almacen> almacenes = new HashMap<>();

    public static List<Almacen> findAll() {
        return new ArrayList<>(almacenes.values());
    }

    public static Almacen findById(String id) {
        return almacenes.get(id);
    }

    public static void save(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
    }
}