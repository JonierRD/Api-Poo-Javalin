package repository;

import models.Producto;
import java.util.*;

public class ProductoRepository {
    private static final Map<String, Producto> productos = new HashMap<>();

    public static List<Producto> findAll() {
        return new ArrayList<>(productos.values());
    }

    public static Producto findById(String id) {
        return productos.get(id);
    }

    public static void save(Producto producto) {
        productos.put(producto.getId(), producto);
    }
}