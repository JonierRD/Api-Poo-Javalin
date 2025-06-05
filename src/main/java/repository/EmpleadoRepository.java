package repository;

import models.Empleado;
import java.util.*;

public class EmpleadoRepository {
    private static final Map<String, Empleado> empleados = new HashMap<>();
    private static final Map<String, List<String>> empleadosPorSucursal = new HashMap<>();

    public static void save(Empleado empleado) {
        empleados.put(empleado.getId(), empleado);
        empleadosPorSucursal
                .computeIfAbsent(empleado.getSucursalId(), k -> new ArrayList<>())
                .add(empleado.getId());
    }

    public static List<Empleado> findBySucursal(String sucursalId) {
        return empleadosPorSucursal.getOrDefault(sucursalId, Collections.emptyList())
                .stream()
                .map(empleados::get)
                .toList();
    }

    public static List<Empleado> findByCargo(String cargo) {
        return empleados.values().stream()
                .filter(e -> e.getCargo().equals(cargo))
                .toList();
    }
}