
package com.mycompany.p2tarea1cevallosbryan;
import java.io.*;
public class ArchivoCSV {
    private static final String ARCHIVO = "personas.csv";

    public static void guardarCSV(Persona[] personas) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Persona p : personas) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }

    public static Persona[] leerCSV() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
        String linea;
        int count = 0;

        while ((linea = reader.readLine()) != null) {
            count++;
        }
        reader.close();

        Persona[] personas = new Persona[count];
        reader = new BufferedReader(new FileReader(ARCHIVO));
        int i = 0;
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            int edad = Integer.parseInt(partes[2]);
            personas[i] = new Persona(id, nombre, edad);
            i++;
        }
        reader.close();
        return personas;
    }
}
