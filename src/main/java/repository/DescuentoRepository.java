package repository;

import models.Descuento;
import java.util.*;

public class DescuentoRepository {
    private static final Map<String, Descuento> descuentos = new HashMap<>();

    public static List<Descuento> findAll() {
        return new ArrayList<>(descuentos.values());
    }

    public static Descuento findById(String id) {
        return descuentos.get(id);
    }

    public static void save(Descuento descuento) {
        descuentos.put(descuento.getId(), descuento);
    }
}