package repository;

import models.Inventario;
import java.util.*;

public class InventarioRepository {  // Nombre corregido
    private static final Map<String, Inventario> items = new HashMap<>();

    public static List<Inventario> findAll() {
        return new ArrayList<>(items.values());
    }

    public static Inventario findById(String id) {
        return items.get(id);
    }

    public static void save(Inventario item) {
        // Asegúrate que la clase Inventario tenga getId()
        items.put(item.getId(), item);
    }
}