package repository;

import models.Factura;
import java.util.*;

public class FacturaRepository {
    private static final Map<String, Factura> facturas = new HashMap<>();
    private static final Map<String, String> facturasPorPedido = new HashMap<>();

    public static void save(Factura factura) {
        facturas.put(factura.getId(), factura);
        facturasPorPedido.put(factura.getPedidoId(), factura.getId());
    }

    public static Factura findByPedidoId(String pedidoId) {
        String facturaId = facturasPorPedido.get(pedidoId);
        return facturaId != null ? facturas.get(facturaId) : null;
    }

    public static List<Factura> findByClienteId(String clienteId) {
        return facturas.values().stream()
                .filter(f -> f.getClienteId().equals(clienteId)) // ✅ Corregido: getClienteId()
                .toList();
    }
}