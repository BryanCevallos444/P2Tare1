package com.mycompany.p2tarea1cevallosbryan;

public class Busqueda {

    public static void busquedaLineal(Persona[] personas, int edad) {
        boolean encontrado = false;
        for (Persona p : personas) {
            if (p.getEdad() == edad) {
                System.out.println("Encontrado: " + p.getNombre() + " - " + p.getEdad());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron personas con esa edad.");
        }
    }

    public static void busquedaBinaria(Persona[] personas, int edad) {
        int izquierda = 0;
        int derecha = personas.length - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (personas[medio].getEdad() == edad) {
                System.out.println("Primera coincidencia binaria: " + personas[medio].getNombre() + " - " + personas[medio].getEdad());
                return;
            } else if (edad < personas[medio].getEdad()) {
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }
        System.out.println("No se encontro coincidencia binaria.");
    }
}