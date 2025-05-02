/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edypi
 */
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Agregar un producto
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Buscar producto por código
    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null; // No encontrado
    }

    // Consultar stock
    public int consultarStock(String codigo) {
        Producto p = buscarProductoPorCodigo(codigo);
        if (p != null) {
            return p.getStock();
        }
        return -1; // Indica que no existe
    }

    // Actualizar precio
    public boolean actualizarPrecio(String codigo, double nuevoPrecio) {
        Producto p = buscarProductoPorCodigo(codigo);
        if (p != null) {
            p.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

    // Realizar venta
    public boolean venderProducto(String codigo, int cantidad) {
        Producto p = buscarProductoPorCodigo(codigo);
        if (p != null && p.getStock() >= cantidad) {
            p.setStock(p.getStock() - cantidad);
            return true;
        }
        return false;
    }

    // Listar todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }
}
