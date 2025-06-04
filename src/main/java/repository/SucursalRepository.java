package repository;

import models.Sucursal;
import java.util.*;

public class SucursalRepository {
    private static final Map<String, Sucursal> sucursales = new HashMap<>();
    private static final Map<String, String> sucursalesPorNombre = new HashMap<>();

    public static void save(Sucursal sucursal) {
        sucursales.put(sucursal.getId(), sucursal);
        sucursalesPorNombre.put(sucursal.getNombre(), sucursal.getId());
    }

    public static Sucursal findByNombre(String nombre) {
        String id = sucursalesPorNombre.get(nombre);
        return id != null ? sucursales.get(id) : null;
    }
}
