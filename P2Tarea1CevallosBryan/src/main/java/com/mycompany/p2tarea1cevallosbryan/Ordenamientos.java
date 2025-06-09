
package com.mycompany.p2tarea1cevallosbryan;

public class Ordenamientos {

    public static void burbuja(Persona[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j].getEdad() > arreglo[j + 1].getEdad()) {
                    Persona temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void seleccion(Persona[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j].getEdad() < arreglo[minIdx].getEdad()) {
                    minIdx = j;
                }
            }
            Persona temp = arreglo[i];
            arreglo[i] = arreglo[minIdx];
            arreglo[minIdx] = temp;
        }
    }

    public static void insercion(Persona[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            Persona actual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j].getEdad() > actual.getEdad()) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
        }
    }

    public static void shell(Persona[] arreglo) {
        int n = arreglo.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Persona temp = arreglo[i];
                int j = i;
                while (j >= gap && arreglo[j - gap].getEdad() > temp.getEdad()) {
                    arreglo[j] = arreglo[j - gap];
                    j -= gap;
                }
                arreglo[j] = temp;
            }
        }
    }

    public static void mergeSort(Persona[] arreglo) {
        mergeSort(arreglo, 0, arreglo.length - 1);
    }

    private static void mergeSort(Persona[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(Persona[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Persona[] L = new Persona[n1];
        Persona[] R = new Persona[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].getEdad() <= R[j].getEdad()) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(Persona[] arreglo) {
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    private static void quickSort(Persona[] arr, int low, int high) {
        if (low < high) {
            int pi = particion(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int particion(Persona[] arr, int low, int high) {
        int pivot = arr[high].getEdad();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getEdad() <= pivot) {
                i++;
                Persona temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Persona temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
