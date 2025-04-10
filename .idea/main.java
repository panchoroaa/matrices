import java.util.Scanner;
import java.util.Random;

public class main {

    // Método para validar las dimensiones
    public static boolean validarDimensiones(int filas, int cols) {
        // Las dimensiones deben ser mayores que 0
        return filas > 0 && cols > 0;
    }

    // Método para crear una matriz de enteros
    public static int[][] crearMatriz(int filas, int cols) {
        return new int[filas][cols];
    }
    // Método para llenar la matriz automáticamente con números aleatorios
    public static void llenarMatrizAleatoria(int[][] matriz) {
        Random random = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // Generar un número aleatorio entre 1 y 100
                matriz[i][j] = random.nextInt(100) + 1; // Rango de 1 a 100
            }
        }
    }

    // Método para mostrar la matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean matrizCero(int[][] matriz) {
        int totalElementos = matriz.length * matriz[0].length;
        int ceros = 0;
        // Contar cuántos ceros hay en la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    ceros++;
                }
            }
        }
        // Verificar si más del 50% de los elementos son ceros
        return ceros > totalElementos / 2;
    }

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer las dimensiones del usuario
        Scanner scanner = new Scanner(System.in);
        // Pedir las dimensiones de la matriz
        int filas = 0, columnas = 0;
        boolean dimensionesValidas = false;

        while (!dimensionesValidas) {
            System.out.print("Ingrese el número de filas de la matriz: ");
            filas = scanner.nextInt();
            System.out.print("Ingrese el número de columnas de la matriz: ");
            columnas = scanner.nextInt();

            // Validar dimensiones
            dimensionesValidas = validarDimensiones(filas, columnas);
            if (!dimensionesValidas) {
                System.out.println("Las dimensiones no son válidas. Deben ser números positivos mayores a 0");
            }
        }
        // Crear la matriz con las dimensiones validadas
        int[][] matriz = crearMatriz(filas, columnas);
        // Llenar la matriz automáticamente con números aleatorios
        llenarMatrizAleatoria(matriz);
        // Mostrar la matriz
        System.out.println("La matriz generada automáticamente es:");
        mostrarMatriz(matriz);

        if (matrizCero(matriz)) {
            System.out.println("La matriz generada es una matriz cero, la mayoria de los números es cero.");
        }
        else
        System.out.println("La matriz no es una matriz cero.");

    }
}
//AAAAAAAAAAAAAAAAAAAA