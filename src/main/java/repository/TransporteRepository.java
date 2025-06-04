package repository;

import models.Transporte;
import java.util.*;

public class TransporteRepository {
    private static final Map<String, Transporte> transportes = new HashMap<>();
    private static final Map<String, String> transportesPorPlaca = new HashMap<>();

    public static void save(Transporte transporte) {
        transportes.put(transporte.getId(), transporte);
        transportesPorPlaca.put(transporte.getPlaca(), transporte.getId());
    }

    public static Transporte findByPlaca(String placa) {
        String id = transportesPorPlaca.get(placa);
        return id != null ? transportes.get(id) : null;
    }

    public static List<Transporte> findDisponibles() {
        return transportes.values().stream()
                .filter(Transporte::isDisponible)
                .toList();
    }
}
