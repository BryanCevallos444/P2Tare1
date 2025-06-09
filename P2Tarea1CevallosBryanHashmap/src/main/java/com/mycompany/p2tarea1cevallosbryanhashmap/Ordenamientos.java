
package com.mycompany.p2tarea1cevallosbryanhashmap;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenamientos {
    
    public static void burbuja(HashMap<Integer, Persona> mapa) {
        List<Persona> lista = new ArrayList<>(mapa.values());
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getEdad() > lista.get(j + 1).getEdad()) {
                    Collections.swap(lista, j, j + 1);
                }
            }
        }
        actualizarMapa(mapa, lista);
    }
    
    public static void seleccion(HashMap<Integer, Persona> mapa) {
        List<Persona> lista = new ArrayList<>(mapa.values());
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).getEdad() < lista.get(minIdx).getEdad()) {
                    minIdx = j;
                }
            }
            Collections.swap(lista, i, minIdx);
        }
        actualizarMapa(mapa, lista);
    }
    
    public static void insercion(HashMap<Integer, Persona> mapa) {
        List<Persona> lista = new ArrayList<>(mapa.values());
        for (int i = 1; i < lista.size(); i++) {
            Persona actual = lista.get(i);
            int j = i - 1;
            while (j >= 0 && lista.get(j).getEdad() > actual.getEdad()) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, actual);
        }
        actualizarMapa(mapa, lista);
    }
    
    public static void shell(HashMap<Integer, Persona> mapa) {
        List<Persona> lista = new ArrayList<>(mapa.values());
        int n = lista.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Persona temp = lista.get(i);
                int j = i;
                while (j >= gap && lista.get(j - gap).getEdad() > temp.getEdad()) {
                    lista.set(j, lista.get(j - gap));
                    j -= gap;
                }
                lista.set(j, temp);
            }
        }
        actualizarMapa(mapa, lista);
    }
    
    public static void mergeSort(HashMap<Integer, Persona> mapa) {
        List<Persona> lista = new ArrayList<>(mapa.values());
        mergeSort(lista, 0, lista.size() - 1);
        actualizarMapa(mapa, lista);
    }
    
    private static void mergeSort(List<Persona> lista, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(lista, left, mid);
            mergeSort(lista, mid + 1, right);
            merge(lista, left, mid, right);
        }
    }
    
    private static void merge(List<Persona> lista, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        List<Persona> L = new ArrayList<>();
        List<Persona> R = new ArrayList<>();
        
        for (int i = 0; i < n1; i++) {
            L.add(lista.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            R.add(lista.get(mid + 1 + j));
        }
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L.get(i).getEdad() <= R.get(j).getEdad()) {
                lista.set(k++, L.get(i++));
            } else {
                lista.set(k++, R.get(j++));
            }
        }
        
        while (i < n1) {
            lista.set(k++, L.get(i++));
        }
        while (j < n2) {
            lista.set(k++, R.get(j++));
        }
    }
    
    public static void quickSort(HashMap<Integer, Persona> mapa) {
        List<Persona> lista = new ArrayList<>(mapa.values());
        quickSort(lista, 0, lista.size() - 1);
        actualizarMapa(mapa, lista);
    }
    
    private static void quickSort(List<Persona> lista, int low, int high) {
        if (low < high) {
            int pi = particion(lista, low, high);
            quickSort(lista, low, pi - 1);
            quickSort(lista, pi + 1, high);
        }
    }
    
    private static int particion(List<Persona> lista, int low, int high) {
        int pivot = lista.get(high).getEdad();
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (lista.get(j).getEdad() <= pivot) {
                i++;
                Collections.swap(lista, i, j);
            }
        }
        Collections.swap(lista, i + 1, high);
        return i + 1;
    }
    
    // Método auxiliar para actualizar el HashMap después del ordenamiento
    private static void actualizarMapa(HashMap<Integer, Persona> mapa, List<Persona> lista) {
        mapa.clear();
        for (Persona persona : lista) {
            mapa.put(persona.getId(), persona);
        }
    }
}