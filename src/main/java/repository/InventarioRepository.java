package repository;

import models.Inventario;
import java.util.*;

public class InventarioRepository {
    private static final Map<String, Inventario> inventarios = new HashMap<>();
    private static final Map<String, List<Inventario>> inventariosPorProducto = new HashMap<>();

    public static void save(Inventario inventario) {
        inventarios.put(inventario.getProductoId() + "-" + inventario.getSucursalId(), inventario);

        inventariosPorProducto
                .computeIfAbsent(inventario.getProductoId(), k -> new ArrayList<>())
                .add(inventario);
    }

    public static Inventario findByProductoYSucursal(String productoId, String sucursalId) {
        return inventarios.get(productoId + "-" + sucursalId);
    }

    public static List<Inventario> findByProducto(String productoId) {
        return inventariosPorProducto.getOrDefault(productoId, Collections.emptyList());
    }
}