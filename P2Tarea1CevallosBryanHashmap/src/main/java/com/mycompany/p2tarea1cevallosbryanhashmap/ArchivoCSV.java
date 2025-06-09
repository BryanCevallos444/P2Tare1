
package com.mycompany.p2tarea1cevallosbryanhashmap;
import java.io.*;
import java.util.HashMap;

public class ArchivoCSV {
    private static final String ARCHIVO = "personas.csv";
    
    public static void guardarCSV(HashMap<Integer, Persona> personas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Persona p : personas.values()) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }
    
    public static HashMap<Integer, Persona> leerCSV() throws IOException {
        HashMap<Integer, Persona> personas = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int edad = Integer.parseInt(partes[2]);
                Persona persona = new Persona(id, nombre, edad);
                personas.put(id, persona); // Usar ID como clave
            }
        }
        
        return personas;
    }
}