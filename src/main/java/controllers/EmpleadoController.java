package controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import models.Empleado;
import repository.EmpleadoRepository;
import java.util.List;

public class EmpleadoController {
    private final Javalin app;

    public EmpleadoController(Javalin app) {
        this.app = app;
        registerRoutes();
    }

    private void registerRoutes() {
        app.get("/api/empleados", this::getAllEmpleados);
        app.post("/api/empleados", this::createEmpleado);
    }

    private void getAllEmpleados(Context ctx) {
        List<Empleado> empleados = EmpleadoRepository.findAll();
        ctx.json(empleados);
    }

    private void createEmpleado(Context ctx) {
        Empleado empleado = ctx.bodyAsClass(Empleado.class);
        EmpleadoRepository.save(empleado);
        ctx.status(201).json(empleado);
    }
}