package repository;

import models.Descuento;
import java.util.*;

public class DescuentoRepository {
    private static final Map<String, Descuento> descuentos = new HashMap<>();
    private static final Map<String, String> descuentosPorCodigo = new HashMap<>();

    public static void save(Descuento descuento) {
        descuentos.put(descuento.getId(), descuento);
        descuentosPorCodigo.put(descuento.getCodigo(), descuento.getId());
    }

    public static Descuento findByCodigo(String codigo) {
        String id = descuentosPorCodigo.get(codigo);
        return id != null ? descuentos.get(id) : null;
    }
}