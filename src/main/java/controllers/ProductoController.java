package controllers;

import io.javalin.http.Context;
import models.Producto;
import repository.ProductoRepository;

public class ProductoController {
    public static void createProducto(Context ctx) {
        Producto producto = ctx.bodyAsClass(Producto.class);
        Producto nuevoProducto = ProductoRepository.addProducto(producto);
        ctx.status(201).json(nuevoProducto);
    }

    public static void getAllProductos(Context ctx) {
        ctx.json(ProductoRepository.getAllProductos());
    }
}