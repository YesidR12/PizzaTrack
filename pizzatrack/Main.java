package pizzatrack;

import java.util.Scanner;

/* Clase principal para ejecutar la consola de Pizza-Track.*/
public class Main {
    public static void main(String[] args) {
        GestionPedidos gestion = new GestionPedidos();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            mostrarMenu(gestion);
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    registrarPizza(scanner, gestion);
                    break;
                case "2":
                    deshacer(gestion);
                    break;
                case "3":
                    rehacer(gestion);
                    break;
                case "4":
                    mostrarPedidoActual(gestion);
                    break;
                case "0":
                    continuar = false;
                    System.out.println("\nPizza-Track finalizado. Hasta pronto.");
                    break;
                default:
                    System.out.println("\nOpcion no valida. Seleccione un numero del menu.");
                }
            }
        scanner.close();
    }

    private static void mostrarMenu(GestionPedidos gestion) {
        System.out.println("\n========== PIZZA-TRACK | YESID RIOS ==========");
        System.out.println("Pedidos activos: " + gestion.cantidadPedidosActivos());
        System.out.println("1. Registrar pizza (Escribir)");
        System.out.println("2. Deshacer (Undo)");
        System.out.println("3. Rehacer (Redo)");
        System.out.println("4. Mostrar pedido actual");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void registrarPizza(Scanner scanner, GestionPedidos gestion) {
        System.out.print("\nNombre de la pizza: ");
        String nombre = scanner.nextLine().trim();
        String[] ingredientes = new String[3];

        for (int i = 0; i < ingredientes.length; i++) {
            System.out.print("Ingrediente " + (i + 1) + ": ");
            ingredientes[i] = scanner.nextLine().trim();
        }

        try {
            Pizza pizza = new Pizza(nombre, ingredientes);
            gestion.registrar(pizza);
            System.out.println("Pizza registrada: " + pizza);
        } catch (IllegalArgumentException exception) {
            System.out.println("No se pudo registrar: " + exception.getMessage());
        }
    }

    private static void deshacer(GestionPedidos gestion) {
        Pizza pizza = gestion.deshacer();
        if (pizza == null) {
            System.out.println("\nNo hay pedidos para deshacer.");
        } else {
            System.out.println("\nPedido deshecho: " + pizza);
        }
    }

    private static void rehacer(GestionPedidos gestion) {
        Pizza pizza = gestion.rehacer();
        if (pizza == null) {
            System.out.println("\nNo hay pedidos para rehacer.");
        } else {
            System.out.println("\nPedido rehecho: " + pizza);
        }
    }

    private static void mostrarPedidoActual(GestionPedidos gestion) {
        Pizza pizza = gestion.pedidoActual();
        if (pizza == null) {
            System.out.println("\nNo hay un pedido activo.");
        } else {
            System.out.println("\nPedido actual listo para produccion: " + pizza);
        }
    }
}

