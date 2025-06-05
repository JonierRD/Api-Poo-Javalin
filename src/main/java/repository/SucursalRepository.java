package repository;

import models.Sucursal;
import java.util.*;

public class SucursalRepository {
    private static final Map<String, Sucursal> sucursales = new HashMap<>();

    public static List<Sucursal> findAll() {
        return new ArrayList<>(sucursales.values());
    }

    public static Sucursal findById(String id) {
        return sucursales.get(id);
    }

    public static void save(Sucursal sucursal) {
        sucursales.put(sucursal.getId(), sucursal);
    }
}