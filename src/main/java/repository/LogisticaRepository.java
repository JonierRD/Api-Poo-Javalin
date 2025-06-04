package repository;

import models.Logistica;
import java.util.*;

public class LogisticaRepository {
    private static final Map<String, Logistica> logisticas = new HashMap<>();
    private static final Map<String, String> logisticasPorPedido = new HashMap<>();

    public static void save(Logistica logistica) {
        logisticas.put(logistica.getId(), logistica);
        logisticasPorPedido.put(logistica.getPedidoId(), logistica.getId());
    }

    public static Logistica findByPedidoId(String pedidoId) {
        String logisticaId = logisticasPorPedido.get(pedidoId);
        return logisticaId != null ? logisticas.get(logisticaId) : null;
    }
}
