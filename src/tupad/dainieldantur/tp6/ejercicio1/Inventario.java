package tupad.dainieldantur.tp6.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        if (p != null) {
            productos.add(p);
            System.out.println("Producto agregado: " + p.getNombre());
        }
    }

    public void listarProductos() {
        System.out.println("\n--- Lista de Productos ---");

        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    public Producto buscarProductoPorId(String id) {
        int i = 0;
        while (i < productos.size() && !productos.get(i).getId().equals(id)) {
            i++;
        }
        return i < productos.size() ? productos.get(i) : null;
    }

    public void eliminarProducto(String id) {
        Producto aEliminar = buscarProductoPorId(id);
        if (aEliminar != null) {
            productos.remove(aEliminar);
            System.out.println("Producto eliminado: " + aEliminar.getNombre());
        } else {
            System.out.println("No se encontró producto con ID: " + id);
        }
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setCantidad(nuevaCantidad);
            System.out.println("Stock actualizado para " + p.getNombre() + " a " + nuevaCantidad + " unidades.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void filtrarPorCategoria(CategoriaProducto categoria) {
        System.out.println("\n--- Productos en categoría: " + categoria + " ---");
        boolean hayProductos = false;
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                p.mostrarInfo();
                hayProductos = true;
            }
        }
        if (!hayProductos)
            System.out.println("No hay productos en esta categoría.");
    }

    public int obtenerTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getCantidad();
        }
        return total;
    }

    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty())
            return null;

        Producto maxProd = productos.get(0);
        for (Producto p : productos) {
            if (p.getCantidad() > maxProd.getCantidad()) {
                maxProd = p;
            }
        }
        return maxProd;
    }

    public void filtrarProductosPorPrecio(double min, double max) {
        System.out.println("\n--- Productos entre $" + min + " y $" + max + " ---");
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
            }
        }
    }

    public void mostrarCategoriasDisponibles() {
        System.out.println("\n--- Categorías Disponibles ---");

        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println(c + ": " + c.getDescripcion());
        }
    }
}