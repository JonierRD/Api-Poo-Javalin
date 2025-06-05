package repository;

import models.Pago;
import java.util.*;

public class PagoRepository {
    private static final Map<String, Pago> pagos = new HashMap<>();

    public static List<Pago> findAll() {
        return new ArrayList<>(pagos.values());
    }

    public static Pago findById(String id) {
        return pagos.get(id);
    }

    public static void save(Pago pago) {
        pagos.put(pago.getId(), pago);
    }
}