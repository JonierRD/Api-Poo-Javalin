package repository;

import models.Pedido;
import java.util.*;

public class PedidoRepository {
    private static final Map<String, Pedido> pedidos = new HashMap<>();

    public static List<Pedido> findAll() {
        return new ArrayList<>(pedidos.values());
    }

    public static Pedido findById(String id) {
        return pedidos.get(id);
    }

    public static void save(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }
}