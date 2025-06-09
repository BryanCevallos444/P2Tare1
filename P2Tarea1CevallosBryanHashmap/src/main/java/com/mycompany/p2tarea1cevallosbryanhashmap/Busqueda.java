package com.mycompany.p2tarea1cevallosbryanhashmap;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Busqueda {
    
    public static void busquedaLineal(HashMap<Integer, Persona> personas, int edad) {
        boolean encontrado = false;
        for (Persona p : personas.values()) {
            if (p.getEdad() == edad) {
                System.out.println("Encontrado: " + p.getNombre() + " - " + p.getEdad() + " (ID: " + p.getId() + ")");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron personas con esa edad.");
        }
    }
    
    public static void busquedaBinaria(HashMap<Integer, Persona> personas, int edad) {
        // Convertir a lista y ordenar por edad para búsqueda binaria
        List<Persona> lista = new ArrayList<>(personas.values());
        lista.sort((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
        
        int izquierda = 0;
        int derecha = lista.size() - 1;
        
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            
            if (lista.get(medio).getEdad() == edad) {
                Persona encontrada = lista.get(medio);
                System.out.println("Primera coincidencia binaria: " + 
                    encontrada.getNombre() + " - " + encontrada.getEdad() + " (ID: " + encontrada.getId() + ")");
                return;
            } else if (edad < lista.get(medio).getEdad()) {
                derecha = medio - 1;
            } else {
                izquierda = medio + 1;
            }
        }
        System.out.println("No se encontro coincidencia binaria.");
    }
    
    // Método adicional para buscar por ID (aprovechando las ventajas del HashMap)
    public static void busquedaPorId(HashMap<Integer, Persona> personas, int id) {
        Persona persona = personas.get(id);
        if (persona != null) {
            System.out.println("Persona encontrada por ID: " + persona.getNombre() + 
                             " - " + persona.getEdad() + " años (ID: " + persona.getId() + ")");
        } else {
            System.out.println("No se encontró persona con ID: " + id);
        }
    }
}