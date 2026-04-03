package com.sebastian.gestionclientes;

import com.sebastian.gestionclientes.dao.ClienteDAO;
import com.sebastian.gestionclientes.model.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        int opcion;

        do {
            System.out.println("\n=== MENU DE CLIENTES ===");
            System.out.println("1. Insertar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por ID");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Salir");

            opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    insertarCliente(scanner, clienteDAO);
                    break;
                case 2:
                    listarClientes(clienteDAO);
                    break;
                case 3:
                    buscarClientePorId(scanner, clienteDAO);
                    break;
                case 4:
                    actualizarCliente(scanner, clienteDAO);
                    break;
                case 5:
                    eliminarCliente(scanner, clienteDAO);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void insertarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, correo, telefono);
        clienteDAO.insertarCliente(cliente);
    }

    private static void listarClientes(ClienteDAO clienteDAO) {
        List<Cliente> clientes = clienteDAO.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente cliente : clientes) {
            mostrarCliente(cliente);
        }
    }

    private static void buscarClientePorId(Scanner scanner, ClienteDAO clienteDAO) {
        int id = leerEntero(scanner, "Ingrese el ID del cliente: ");
        Cliente cliente = clienteDAO.buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("No se encontro un cliente con ese ID.");
            return;
        }

        System.out.println("\n=== CLIENTE ENCONTRADO ===");
        mostrarCliente(cliente);
    }

    private static void actualizarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        int id = leerEntero(scanner, "Ingrese el ID del cliente a actualizar: ");
        Cliente clienteExistente = clienteDAO.buscarClientePorId(id);

        if (clienteExistente == null) {
            System.out.println("No existe un cliente con ese ID.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Nuevo correo: ");
        String correo = scanner.nextLine();

        System.out.print("Nuevo telefono: ");
        String telefono = scanner.nextLine();

        Cliente clienteActualizado = new Cliente();
        clienteActualizado.setId(id);
        clienteActualizado.setNombre(nombre);
        clienteActualizado.setApellido(apellido);
        clienteActualizado.setCorreo(correo);
        clienteActualizado.setTelefono(telefono);

        clienteDAO.actualizarCliente(clienteActualizado);
    }

    private static void eliminarCliente(Scanner scanner, ClienteDAO clienteDAO) {
        int id = leerEntero(scanner, "Ingrese el ID del cliente a eliminar: ");
        Cliente clienteExistente = clienteDAO.buscarClientePorId(id);

        if (clienteExistente == null) {
            System.out.println("No existe un cliente con ese ID.");
            return;
        }

        clienteDAO.eliminarCliente(id);
    }

    private static void mostrarCliente(Cliente cliente) {
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Fecha registro: " + cliente.getFechaRegistro());
        System.out.println("----------------------------");
    }

    // Centraliza la lectura de enteros para evitar que el menu falle por entradas invalidas.
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            }

            System.out.println("Entrada invalida. Debe ingresar un numero.");
            scanner.nextLine();
        }
    }
}
