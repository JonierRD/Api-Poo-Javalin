package repository;

import models.Proveedor;
import java.util.*;

public class ProveedorRepository {
    private static final Map<String, Proveedor> proveedores = new HashMap<>();

    public static List<Proveedor> findAll() {
        return new ArrayList<>(proveedores.values());
    }

    public static Proveedor findById(String id) {
        return proveedores.get(id);
    }

    public static void save(Proveedor proveedor) {
        proveedores.put(proveedor.getId(), proveedor);
    }
}