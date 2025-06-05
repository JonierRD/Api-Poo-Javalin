package repository;

import models.Carrito;
import java.util.*;

public class CarritoRepository {
    private static final Map<String, Carrito> carritos = new HashMap<>();

    public static List<Carrito> findAll() {
        return new ArrayList<>(carritos.values());
    }

    public static Carrito findById(String id) {
        return carritos.get(id);
    }

    public static void save(Carrito carrito) {
        carritos.put(carrito.getId(), carrito);
    }
}