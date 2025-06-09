package com.mycompany.p2tarea1cevallosbryan;

import java.util.ArrayList;

public class Busqueda {
    
    public static void busquedaLineal(ArrayList<Persona> personas, int edad) {
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
    
    public static void busquedaBinaria(ArrayList<Persona> personas, int edad) {
        int izquierda = 0;
        int derecha = personas.size() - 1;
        
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            
            if (personas.get(medio).getEdad() == edad) {
                System.out.println("Primera coincidencia binaria: " + 
                    personas.get(medio).getNombre() + " - " + personas.get(medio).getEdad());
                return;
            } else if (edad < personas.get(medio).getEdad()) {
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }
        System.out.println("No se encontro coincidencia binaria.");
    }
}
