package repository;

import models.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private static List<Producto> productos = new ArrayList<>();
    private static int nextId = 1;

    public static Producto addProducto(Producto producto) {
        producto.setId("PROD-" + nextId++);
        productos.add(producto);
        return producto;
    }

    public static List<Producto> getAllProductos() {
        return new ArrayList<>(productos);
    }

    public static Optional<Producto> getProductoById(String id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}