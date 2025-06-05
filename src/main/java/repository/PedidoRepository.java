package repository; // Nota: Tu paquete se llama "repository" (sin 's')

import models.Pedido;
import java.util.*;

public class PedidoRepository {
    private static final Map<String, Pedido> pedidos = new HashMap<>();

    // Métodos CRUD (sin dependencias externas)
    public static void save(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    public static Pedido findById(String id) {
        return pedidos.get(id);
    }

    public static List<Pedido> findAll() {
        return new ArrayList<>(pedidos.values());
    }

    public static void update(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    public static boolean delete(String id) {
        return pedidos.remove(id) != null;
    }
}