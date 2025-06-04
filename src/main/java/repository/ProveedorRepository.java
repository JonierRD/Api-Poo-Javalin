package repository;

import models.Proveedor;
import java.util.*;

public class ProveedorRepository {
    private static final Map<String, Proveedor> proveedores = new HashMap<>();
    private static final Map<String, String> proveedoresPorNombre = new HashMap<>();

    public static void save(Proveedor proveedor) {
        proveedores.put(proveedor.getId(), proveedor);
        proveedoresPorNombre.put(proveedor.getNombre(), proveedor.getId());
    }

    public static Proveedor findByNombre(String nombre) {
        String id = proveedoresPorNombre.get(nombre);
        return id != null ? proveedores.get(id) : null;
    }

    public static List<Proveedor> findByProducto(String productoId) {
        return proveedores.values().stream()
                .filter(p -> p.getProductosSuministrados().contains(productoId))
                .toList();
    }
}