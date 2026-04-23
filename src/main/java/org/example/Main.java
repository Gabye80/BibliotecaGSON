package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorPeliculas gestor = new GestorPeliculas();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== BIBLIOTECA DE PELÍCULAS ===");
            System.out.println("1. Listar todas");
            System.out.println("2. Añadir película");
            System.out.println("3. Modificar película");
            System.out.println("4. Eliminar película");
            System.out.println("5. Buscar por ID");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    List<Pelicula> lista = gestor.listarTodas();
                    if (lista.isEmpty()) {
                        System.out.println("No hay películas registradas.");
                    } else {
                        System.out.println("ID | Título | Director | Año | Estado | Categoría");
                        lista.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Director: ");
                    String director = sc.nextLine();
                    System.out.print("Año: ");
                    int anio = sc.nextInt(); sc.nextLine();
                    System.out.print("¿Ganadora? (true/false): ");
                    boolean ganadora = sc.nextBoolean(); sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();
                    gestor.agregar(new Pelicula(id, titulo, director, anio, ganadora, categoria));
                }
                case 3 -> {
                    System.out.print("ID a modificar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Nuevo director: ");
                    String director = sc.nextLine();
                    System.out.print("Nuevo año: ");
                    int anio = sc.nextInt(); sc.nextLine();
                    System.out.print("¿Ganadora? (true/false): ");
                    boolean ganadora = sc.nextBoolean(); sc.nextLine();
                    System.out.print("Nueva categoría: ");
                    String categoria = sc.nextLine();
                    gestor.modificar(id, new Pelicula(0, titulo, director, anio, ganadora, categoria));
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    gestor.eliminar(id);
                }
                case 5 -> {
                    System.out.print("ID a buscar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    Pelicula p = gestor.buscarPorId(id);
                    if (p != null) {
                        System.out.println("Película encontrada: " + p);
                    } else {
                        System.out.println("No se encontró ninguna película con ese ID.");
                    }
                }
                case 0 -> System.out.println("Hasta luego.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
