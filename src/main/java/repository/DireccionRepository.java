package repository;

import models.Direccion;
import java.util.*;

public class DireccionRepository {
    private static final Map<String, Direccion> direcciones = new HashMap<>();
    private static final Map<String, List<Direccion>> direccionesPorUsuario = new HashMap<>();

    public static void save(Direccion direccion) {
        direcciones.put(direccion.getId(), direccion);
        direccionesPorUsuario
                .computeIfAbsent(direccion.getUsuarioId(), k -> new ArrayList<>())
                .add(direccion);
    }

    public static List<Direccion> findByUsuarioId(String usuarioId) {
        return direccionesPorUsuario.getOrDefault(usuarioId, Collections.emptyList());
    }

    public static Direccion findPrincipalByUsuarioId(String usuarioId) {
        return direccionesPorUsuario.getOrDefault(usuarioId, Collections.emptyList())
                .stream()
                .filter(Direccion::isEsPrincipal)
                .findFirst()
                .orElse(null);
    }
}