
package com.mycompany.p2tarea1cevallosbryan;
import java.io.*;
import java.util.ArrayList;

public class ArchivoCSV {
    private static final String ARCHIVO = "personas.csv";
    
    public static void guardarCSV(ArrayList<Persona> personas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Persona p : personas) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }
    
    public static ArrayList<Persona> leerCSV() throws IOException {
        ArrayList<Persona> personas = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int edad = Integer.parseInt(partes[2]);
                personas.add(new Persona(id, nombre, edad));
            }
        }
        
        return personas;
    }
}