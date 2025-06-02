package controller;

import model.*;
import service.*;

import java.util.Scanner;

public class MenuController {
    private Scanner scanner = new Scanner(System.in);
    private ProveedorService proveedorService = new ProveedorService();
    private ProductoService productoService = new ProductoService();
    private SolicitudService solicitudService = new SolicitudService();

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Registrar producto");
            System.out.println("3. Registrar solicitud de compra");
            System.out.println("4. Listar proveedores");
            System.out.println("5. Listar productos");
            System.out.println("6. Listar solicitudes de compra");
            System.out.println("7. Buscar proveedor por ID");
            System.out.println("8. Buscar producto por nombre");
            System.out.println("9. Buscar solicitud por número");
            System.out.println("13. Aprobar / Rechazar solicitud de compra");
            System.out.println("14. Calcular total de una solicitud");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarProveedor();
                case 2 -> registrarProducto();
                case 3 -> registrarSolicitud();
                case 4 -> proveedorService.listarProveedores().forEach(System.out::println);
                case 5 -> productoService.listarProductos().forEach(System.out::println);
                case 6 -> solicitudService.listarSolicitudes().forEach(System.out::println);
                case 7 -> buscarProveedor();
                case 8 -> buscarProducto();
                case 9 -> buscarSolicitud();
                case 13 -> aprobarRechazar();
                case 14 -> calcularTotal();
            }

        } while (opcion != 15);
    }

    private void registrarProveedor() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Empresa: ");
        String empresa = scanner.nextLine();

        proveedorService.registrarProveedor(new Proveedor(id, nombre, empresa));
    }

    private void registrarProducto() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble(); scanner.nextLine();

        productoService.registrarProducto(new Producto(codigo, nombre, precio));
    }

    private void registrarSolicitud() {
        System.out.print("ID proveedor: ");
        String id = scanner.nextLine();
        Proveedor p = proveedorService.buscarPorId(id);
        if (p == null) {
            System.out.println("Proveedor no encontrado.");
            return;
        }

        SolicitudCompra solicitud = new SolicitudCompra(p);
        String nombre;
        do {
            System.out.print("Nombre producto (ENTER para terminar): ");
            nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                Producto prod = productoService.buscarPorNombre(nombre);
                if (prod != null) solicitud.agregarProducto(prod);
                else System.out.println("Producto no encontrado.");
            }
        } while (!nombre.isEmpty());

        solicitudService.registrarSolicitud(solicitud);
    }

    private void buscarProveedor() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        Proveedor p = proveedorService.buscarPorId(id);
        System.out.println(p != null ? p : "No encontrado");
    }

    private void buscarProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        Producto p = productoService.buscarPorNombre(nombre);
        System.out.println(p != null ? p : "No encontrado");
    }

    private void buscarSolicitud() {
        System.out.print("Número: ");
        int n = scanner.nextInt(); scanner.nextLine();
        SolicitudCompra s = solicitudService.buscarPorNumero(n);
        System.out.println(s != null ? s : "No encontrada");
    }

    private void aprobarRechazar() {
        System.out.print("Número de solicitud: ");
        int n = scanner.nextInt(); scanner.nextLine();
        SolicitudCompra s = solicitudService.buscarPorNumero(n);
        if (s == null) {
            System.out.println("No encontrada");
            return;
        }
        System.out.print("¿Aprobar (A) o Rechazar (R)?: ");
        String r = scanner.nextLine().toUpperCase();
        if (r.equals("A")) s.aprobar();
        else if (r.equals("R")) s.rechazar();
        else System.out.println("Opción inválida.");
    }

    private void calcularTotal() {
        System.out.print("Número de solicitud: ");
        int n = scanner.nextInt(); scanner.nextLine();
        SolicitudCompra s = solicitudService.buscarPorNumero(n);
        if (s != null)
            System.out.println("Total: $" + s.calcularTotal());
        else
            System.out.println("No encontrada");
    }
}
