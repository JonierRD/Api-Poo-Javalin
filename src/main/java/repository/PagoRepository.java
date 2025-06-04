package repository;

import models.Pago;
import java.util.*;

public class PagoRepository {
    private static final Map<String, Pago> pagos = new HashMap<>();
    private static final Map<String, String> pagosPorPedido = new HashMap<>();

    public static void save(Pago pago) {
        pagos.put(pago.getId(), pago);
        pagosPorPedido.put(pago.getPedidoId(), pago.getId());
    }

    public static Pago findByPedidoId(String pedidoId) {
        String pagoId = pagosPorPedido.get(pedidoId);
        return pagoId != null ? pagos.get(pagoId) : null;
    }
}