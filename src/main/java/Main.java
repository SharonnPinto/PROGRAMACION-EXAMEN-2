/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author edypi
 */
import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {
            System.out.println("\n=== Sistema de Gestión de Inventario para Farmacia ===");
            System.out.println("1. Registrar producto");
            System.out.println("2. Consultar stock");
            System.out.println("3. Actualizar precio");
            System.out.println("4. Realizar venta");
            System.out.println("5. Listar todos los productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarProducto(scanner, inventario);
                    break;
                case 2:
                    consultarStock(scanner, inventario);
                    break;
                case 3:
                    actualizarPrecio(scanner, inventario);
                    break;
                case 4:
                    realizarVenta(scanner, inventario);
                    break;
                case 5:
                    inventario.listarProductos();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void registrarProducto(Scanner scanner, Inventario inventario) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese el stock inicial: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); 

        Producto producto = new Producto(nombre, codigo, precio, stock);
        inventario.agregarProducto(producto);
        System.out.println("Producto registrado exitosamente.");
    }

    private static void consultarStock(Scanner scanner, Inventario inventario) {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        int stock = inventario.consultarStock(codigo);
        if (stock >= 0) {
            System.out.println("El stock del producto con código " + codigo + " es: " + stock);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void actualizarPrecio(Scanner scanner, Inventario inventario) {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine();

        boolean actualizado = inventario.actualizarPrecio(codigo, nuevoPrecio);
        if (actualizado) {
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void realizarVenta(Scanner scanner, Inventario inventario) {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        boolean vendido = inventario.venderProducto(codigo, cantidad);
        if (vendido) {
            System.out.println("Venta realizada con éxito.");
        } else {
            System.out.println("No se pudo realizar la venta. Verifique el código o el stock.");
        }
    }
    }
    

