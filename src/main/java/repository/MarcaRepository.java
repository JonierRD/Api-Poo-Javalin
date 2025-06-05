package repository;

import models.Marca;
import java.util.*;

public class MarcaRepository {
    private static final Map<String, Marca> marcas = new HashMap<>();
    private static final Map<String, String> marcasPorNombre = new HashMap<>();

    public static void save(Marca marca) {
        marcas.put(marca.getId(), marca);
        marcasPorNombre.put(marca.getNombre(), marca.getId());
    }

    public static Marca findByNombre(String nombre) {
        String id = marcasPorNombre.get(nombre);
        return id != null ? marcas.get(id) : null;
    }
}