import java.util.Scanner;
import java.util.Random;

public class matrices {

    // Método para validar las dimensiones
    public static boolean validarDimensiones(int filas, int cols) {
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

    // Método para verificar si la matriz es de tipo cero
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

    // Método para pedir las dimensiones de la matriz
    public static int[] pedirDimensionesMatriz() {
        Scanner scanner = new Scanner(System.in);
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
                System.out.println("Las dimensiones no son válidas. Deben ser números positivos mayores a 0.");
            }
        }
        return new int[]{filas, columnas}; // Devuelve un array con las dimensiones [filas, columnas]
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriz = null;
        int filas = 0, columnas = 0;

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ingresar dimensiones y generar matriz");
            System.out.println("2. Mostrar matriz generada");
            System.out.println("3. Verificar si la matriz es de tipo cero");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt(); // Declara 'opcion' fuera del 'switch'

            switch (opcion) {
                case 1:
                    // Usamos el método para pedir las dimensiones
                    int[] dimensiones = pedirDimensionesMatriz();
                    filas = dimensiones[0];
                    columnas = dimensiones[1];

                    // Crear la matriz con las dimensiones validadas
                    matriz = crearMatriz(filas, columnas);

                    // Llenar la matriz automáticamente con números aleatorios
                    llenarMatrizAleatoria(matriz);
                    System.out.println("Matriz generada correctamente.");
                    break;

                case 2:
                    // Mostrar la matriz generada
                    if (matriz == null) {
                        System.out.println("No se ha generado ninguna matriz. Por favor, seleccione la opción 1 primero.");
                    } else {
                        System.out.println("La matriz generada es:");
                        mostrarMatriz(matriz);
                    }
                    break;

                case 3:
                    // Verificar si la matriz es de tipo cero
                    if (matriz == null) {
                        System.out.println("No se ha generado ninguna matriz. Por favor, seleccione la opción 1 primero.");
                    } else {
                        if (matrizCero(matriz)) {
                            System.out.println("La matriz generada es una matriz cero, la mayoría de los números son ceros.");
                        } else {
                            System.out.println("La matriz no es una matriz cero.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("¡Adiós!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida, por favor elija una opción válida.");
            }
        }
    }
}

//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA