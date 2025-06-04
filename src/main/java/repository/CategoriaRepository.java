package repository;

import models.Categoria;
import java.util.*;

public class CategoriaRepository {
    private static final Map<String, Categoria> categorias = new HashMap<>();
    private static final Map<String, String> categoriasPorNombre = new HashMap<>();

    public static void save(Categoria categoria) {
        categorias.put(categoria.getId(), categoria);
        categoriasPorNombre.put(categoria.getNombre(), categoria.getId());
    }

    public static Categoria findByNombre(String nombre) {
        String id = categoriasPorNombre.get(nombre);
        return id != null ? categorias.get(id) : null;
    }
}