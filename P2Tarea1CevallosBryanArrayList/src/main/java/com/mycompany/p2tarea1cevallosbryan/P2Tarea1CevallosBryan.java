

package com.mycompany.p2tarea1cevallosbryan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class P2Tarea1CevallosBryan {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File archivo = new File("personas.csv");

        if (!archivo.exists()) {
            System.out.print("No se encontro 'personas.csv'. Cuantas personas deseas generar?: ");
            int cantidad = sc.nextInt();
            ArrayList<Persona> personas = new ArrayList<>();

            for (int i = 0; i < cantidad; i++) {
                int id = (int)(Math.random() * 1000);
                String nombre = "Persona" + i;
                int edad = (int)(Math.random() * 100);
                personas.add(new Persona(id, nombre, edad));
            }

            ArchivoCSV.guardarCSV(personas);
            System.out.println("Archivo personas.csv creado con " + cantidad + " personas.");
        }

        int opcion;
        do {
            System.out.println("\n======= MENU PRINCIPAL =======");
            System.out.println("1. Ordenar por metodo Burbuja");
            System.out.println("2. Ordenar por metodo Seleccion");
            System.out.println("3. Ordenar por metodo Insercion");
            System.out.println("4. Ordenar por metodo Shell");
            System.out.println("5. Ordenar por metodo MergeSort");
            System.out.println("6. Ordenar por metodo QuickSort");
            System.out.println("7. Busqueda lineal por edad");
            System.out.println("8. Busqueda binaria por edad");
            System.out.println("9. Regenerar CSV con nuevas personas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 9) {
                System.out.print("Cuantas personas deseas generar?: ");
                int cantidad = sc.nextInt();
                ArrayList<Persona> personas = new ArrayList<>();

                for (int i = 0; i < cantidad; i++) {
                    int id = (int)(Math.random() * 1000);
                    String nombre = "Persona" + i;
                    int edad = (int)(Math.random() * 100);
                    personas.add(new Persona(id, nombre, edad));
                }

                ArchivoCSV.guardarCSV(personas);
                System.out.println("CSV actualizado con nuevas personas.");
                continue;
            }

            ArrayList<Persona> personas = ArchivoCSV.leerCSV();

            switch (opcion) {
                case 1 -> ejecutarOrdenamiento("Burbuja", personas, Ordenamientos::burbuja);
                case 2 -> ejecutarOrdenamiento("Seleccion", personas, Ordenamientos::seleccion);
                case 3 -> ejecutarOrdenamiento("Insercion", personas, Ordenamientos::insercion);
                case 4 -> ejecutarOrdenamiento("Shell", personas, Ordenamientos::shell);
                case 5 -> ejecutarOrdenamiento("MergeSort", personas, Ordenamientos::mergeSort);
                case 6 -> ejecutarOrdenamiento("QuickSort", personas, Ordenamientos::quickSort);
                case 7 -> {
                    System.out.print("Ingrese la edad a buscar: ");
                    int edad = sc.nextInt();
                    Busqueda.busquedaLineal(personas, edad);
                }
                case 8 -> {
                    Ordenamientos.burbuja(personas); // ordenar antes de búsqueda binaria
                    System.out.print("Ingrese la edad a buscar: ");
                    int edadBinaria = sc.nextInt();
                    Busqueda.busquedaBinaria(personas, edadBinaria);
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
        
        sc.close();
    }

    public static void ejecutarOrdenamiento(String metodo, ArrayList<Persona> personas, Ordenamiento orden) {
        long inicio = System.nanoTime();
        orden.ordenar(personas);
        long fin = System.nanoTime();

        System.out.println("\nPersonas ordenadas por " + metodo + ":");
        for (Persona p : personas) {
            System.out.println(p.getNombre() + " - " + p.getEdad());
        }

        System.out.println("Tiempo en nanosegundos: " + (fin - inicio));
    }

    @FunctionalInterface
    public interface Ordenamiento {
        void ordenar(ArrayList<Persona> personas);
    }
}