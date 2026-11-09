package com.utc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ventanillaclientes {

    public static void main(String[] args) {
        Queue<Cliente> colaEspera = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("=== Simulador de Atención en Ventanilla (Soporte Técnico / Banco) ===");

        while (opcion != 5) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar nuevo cliente (Encolar)");
            System.out.println("2. Atender al siguiente cliente (Desencolar)");
            System.out.println("3. Consultar próximo cliente (Inspeccionar)");
            System.out.println("4. Ver estado de la cola");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID o Ticket del cliente: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el motivo de la consulta: ");
                    String motivo = scanner.nextLine();
                    
                    Cliente nuevoCliente = new Cliente(id, nombre, motivo);
                    colaEspera.offer(nuevoCliente);
                    System.out.println("-> Cliente registrado exitosamente.");
                    break;

                case 2:
                    if (colaEspera.isEmpty()) {
                        System.out.println("-> Advertencia: La cola está vacía. No hay clientes por atender.");
                    } else {
                        Cliente clienteAtendido = colaEspera.poll();
                        System.out.println("-> Atendiendo a: \n   " + clienteAtendido.toString());
                    }
                    break;

                case 3:
                    if (colaEspera.isEmpty()) {
                        System.out.println("-> La cola está vacía. No hay próximo cliente.");
                    } else {
                        Cliente proximoCliente = colaEspera.peek();
                        System.out.println("-> El próximo cliente en la fila es: \n   " + proximoCliente.toString());
                    }
                    break;

                case 4:
                    System.out.println("-> Número total de clientes en espera: " + colaEspera.size());
                    if (!colaEspera.isEmpty()) {
                        System.out.println("--- Lista de espera (Orden de atención) ---");
                        int contador = 1;
                        for (Cliente c : colaEspera) {
                            System.out.println(contador + ". " + c.toString());
                            contador++;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Finalizando la ejecución del programa. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("-> Opción no válida. Por favor, intente de nuevo.");
            }
        }
        scanner.close();
    }
}