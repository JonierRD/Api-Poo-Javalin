package repository;

import models.Transporte;
import java.util.*;

public class TransporteRepository {
    private static final Map<String, Transporte> transportes = new HashMap<>();

    public static List<Transporte> findAll() {
        return new ArrayList<>(transportes.values());
    }

    public static Transporte findById(String id) {
        return transportes.get(id);
    }

    public static void save(Transporte transporte) {
        transportes.put(transporte.getId(), transporte);
    }
}