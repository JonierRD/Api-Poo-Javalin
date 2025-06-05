package repository;

import models.Resena;
import java.util.*;

public class ResenaRepository {
    private static final Map<String, Resena> resenas = new HashMap<>();
    private static final Map<String, List<Resena>> resenasPorProducto = new HashMap<>();

    public static void save(Resena resena) {
        if (!resena.esValida()) throw new IllegalArgumentException("Reseña inválida");

        resenas.put(resena.getId(), resena);
        resenasPorProducto
                .computeIfAbsent(resena.getProductoId(), k -> new ArrayList<>())
                .add(resena);
    }

    public static List<Resena> findByProductoId(String productoId) {
        return resenasPorProducto.getOrDefault(productoId, Collections.emptyList());
    }

    public static double getPromedioCalificaciones(String productoId) {
        return resenasPorProducto.getOrDefault(productoId, Collections.emptyList())
                .stream()
                .mapToInt(Resena::getCalificacion)
                .average()
                .orElse(0.0);
    }
}