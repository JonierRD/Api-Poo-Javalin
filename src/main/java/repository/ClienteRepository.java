package repository;

import models.Cliente;
import java.util.*;

public class ClienteRepository {
    private static final Map<String, Cliente> clientes = new HashMap<>();
    private static final Map<String, String> clientesPorEmail = new HashMap<>();

    public static void save(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
        clientesPorEmail.put(cliente.getEmail(), cliente.getId());
    }

    public static Cliente findByEmail(String email) {
        String id = clientesPorEmail.get(email);
        return id != null ? clientes.get(id) : null;
    }

    public static List<Cliente> findByTipo(String tipo) {
        return clientes.values().stream()
                .filter(c -> c.getTipo().equals(tipo))
                .toList();
    }
}