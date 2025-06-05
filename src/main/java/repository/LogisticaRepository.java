package repository;

import models.Logistica;
import java.util.*;

public class LogisticaRepository {
    private static final Map<String, Logistica> logisticas = new HashMap<>();

    public static List<Logistica> findAll() {
        return new ArrayList<>(logisticas.values());
    }

    public static Logistica findById(String id) {
        return logisticas.get(id);
    }

    public static void save(Logistica logistica) {
        logisticas.put(logistica.getId(), logistica);
    }
}