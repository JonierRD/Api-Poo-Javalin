package repository;

import models.Categoria;
import java.util.*;

public class CategoriaRepository {
    private static final Map<String, Categoria> categorias = new HashMap<>();

    public static List<Categoria> findAll() {
        return new ArrayList<>(categorias.values());
    }

    public static Categoria findById(String id) {
        return categorias.get(id);
    }

    public static void save(Categoria categoria) {
        categorias.put(categoria.getId(), categoria);
    }
}