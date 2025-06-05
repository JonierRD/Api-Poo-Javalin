package repository;

import models.Empleado;
import java.util.*;

public class EmpleadoRepository {
    private static final Map<String, Empleado> empleados = new HashMap<>();

    public static List<Empleado> findAll() {
        return new ArrayList<>(empleados.values());
    }

    public static Empleado findById(String id) {
        return empleados.get(id);
    }

    public static void save(Empleado empleado) {
        empleados.put(empleado.getId(), empleado);
    }
}