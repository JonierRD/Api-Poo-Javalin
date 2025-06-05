package repository;

import models.Marca;
import java.util.*;

public class MarcaRepository {
    private static final Map<String, Marca> marcas = new HashMap<>();

    public static List<Marca> findAll() {
        return new ArrayList<>(marcas.values());
    }

    public static Marca findById(String id) {
        return marcas.get(id);
    }

    public static void save(Marca marca) {
        marcas.put(marca.getId(), marca);
    }
}