package repository;

import models.Carrito;
import java.util.*;

public class CarritoRepository {
    private static final Map<String, Carrito> carritos = new HashMap<>();
    private static final Map<String, String> carritosPorUsuario = new HashMap<>();

    // Guardar o actualizar carrito
    public static void save(Carrito carrito) {
        carritos.put(carrito.getId(), carrito);
        carritosPorUsuario.put(carrito.getUsuarioId(), carrito.getId());
    }

    // Buscar por ID
    public static Carrito findById(String id) {
        return carritos.get(id);
    }

    // Buscar por usuario
    public static Carrito findByUsuarioId(String usuarioId) {
        String carritoId = carritosPorUsuario.get(usuarioId);
        return carritoId != null ? carritos.get(carritoId) : null;
    }

    // Eliminar carrito
    public static void delete(String id) {
        Carrito carrito = carritos.get(id);
        if (carrito != null) {
            carritosPorUsuario.remove(carrito.getUsuarioId());
            carritos.remove(id);
        }
    }
}