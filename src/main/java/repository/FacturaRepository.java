package repository;

import models.Factura;
import java.util.*;

public class FacturaRepository {
    private static final Map<String, Factura> facturas = new HashMap<>();

    public static List<Factura> findAll() {
        return new ArrayList<>(facturas.values());
    }

    public static Factura findById(String id) {
        return facturas.get(id);
    }

    public static void save(Factura factura) {
        facturas.put(factura.getId(), factura);
    }
}