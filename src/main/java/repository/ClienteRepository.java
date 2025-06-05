package repository;

import models.Cliente;
import java.util.*;

public class ClienteRepository {
    private static final Map<String, Cliente> clientes = new HashMap<>();

    public static List<Cliente> findAll() {
        return new ArrayList<>(clientes.values());
    }

    public static Cliente findById(String id) {
        return clientes.get(id);
    }

    public static void save(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
    }
}