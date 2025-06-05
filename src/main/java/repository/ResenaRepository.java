package repository;

import models.Resena;
import java.util.*;

public class ResenaRepository {
    private static final Map<String, Resena> resenas = new HashMap<>();

    public static List<Resena> findAll() {
        return new ArrayList<>(resenas.values());
    }

    public static Resena findById(String id) {
        return resenas.get(id);
    }

    public static void save(Resena resena) {
        resenas.put(resena.getId(), resena);
    }
}