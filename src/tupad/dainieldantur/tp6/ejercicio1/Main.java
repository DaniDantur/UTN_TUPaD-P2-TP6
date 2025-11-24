package tupad.dainieldantur.tp6.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Inventario miInventario = new Inventario();

        // 1. Crear al menos cinco productos con diferentes categorías y agregarlos
        System.out.println("1. AGREGANDO PRODUCTOS...");
        miInventario.agregarProducto(new Producto("P001", "Laptop Dell", 150000.0, 10, CategoriaProducto.ELECTRONICA));
        miInventario.agregarProducto(new Producto("P002", "Medias negras", 2500.0, 50, CategoriaProducto.ROPA));
        miInventario.agregarProducto(new Producto("P003", "Arroz 1kg", 1200.0, 100, CategoriaProducto.ALIMENTOS));
        miInventario.agregarProducto(new Producto("P004", "Silla plegable", 45000.0, 5, CategoriaProducto.HOGAR));
        miInventario.agregarProducto(new Producto("P005", "Mouse Logitech", 2800.0, 20, CategoriaProducto.ELECTRONICA));

        // 2. Listar todos los productos mostrando su información y categoría.
        System.out.println("\n2. LISTADO COMPLETO:");
        miInventario.listarProductos();

        // 3. Buscar un producto por ID y mostrar su información.
        System.out.println("\n3. BUSQUEDA POR ID (P003):");
        Producto buscado = miInventario.buscarProductoPorId("P003");
        if (buscado != null) {
            buscado.mostrarInfo();
        }

        // 4. Filtrar y mostrar productos que pertenezcan a una categoría específica.
        System.out.println("\n4. FILTRADO POR CATEGORIA (ELECTRONICA):");
        miInventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);

        // 5. Eliminar un producto por su ID y listar los productos restantes.
        System.out.println("\n5. ELIMINAR PRODUCTO (P002):");
        miInventario.eliminarProducto("P002");
        miInventario.listarProductos();

        // 6. Actualizar el stock de un producto existente.
        System.out.println("\n6. ACTUALIZAR STOCK (P001 a 15 unidades):");
        miInventario.actualizarStock("P001", 15);

        // 7. Mostrar el total de stock disponible.
        System.out.println("\n7. TOTAL DE STOCK EN INVENTARIO:");
        System.out.println("Unidades totales: " + miInventario.obtenerTotalStock());

        // 8. Obtener y mostrar el producto con mayor stock.
        System.out.println("\n8. PRODUCTO CON MAYOR STOCK:");
        Producto mayorStock = miInventario.obtenerProductoConMayorStock();
        if (mayorStock != null)
            System.out.println(mayorStock.getNombre() + " (Cantidad: " + mayorStock.getCantidad() + ")");

        // 9. Filtrar productos con precios entre $1000 y $3000.
        System.out.println("\n9. FILTRAR POR PRECIO (de $1000 a $3000):");
        miInventario.filtrarProductosPorPrecio(1000, 3000);

        // 10. Mostrar las categorías disponibles con sus descripciones.
        System.out.println("\n10. CATEGORIAS DISPONIBLES:");
        miInventario.mostrarCategoriasDisponibles();
    }
}
