package lab7p1_joseseron;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jose Seron
 */
public class Lab7P1_JoseSeron {

    //Fila 2 Silla 9
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        boolean bandera = true;

        System.out.println("<-------LABORATORIO 7------->");

        while (bandera) {
            int opcion = 0;
            System.out.println("Ingrese el ejercicio de desea ejecutar: ");
            System.out.println("1--> Tres en Fila ");
            System.out.println("2--> Puntos de Silla");
            System.out.println("3--> Salir del programa");
            opcion = input.nextInt();

            while (opcion < 1 || opcion > 4) {
                System.out.println("Ingrese una opcion valida (1, 2, 3)");
                opcion = input.nextInt();
            }

            switch (opcion) {
                case 1:
                    boolean bandera1 = true;

                    while (bandera1) {
                        System.out.println("El Jugador sera X!");
                        System.out.println("La Maquina sera 0!");
                        int opcion1;
                        int cont = 0;
                        boolean ganoX = false;
                        boolean gano0 = false;
                        System.out.println("");
                        System.out.println("----------Bienvenido al Tres en Raya----------");
                        System.out.println("Tablero Actual");

                        int size = 3;
                        char[][] tablero = new char[size][size];
                        tablero = generarTablero(tablero);
                        imprimir(tablero);

                        System.out.println("");

                        boolean verficarVictoria = true;
                        int posY = 0;
                        int posX = 0;
                        boolean esValido = false;

                        while (verficarVictoria) {

                            System.out.println("");
                            System.out.println("Es el turno de X");

                            while (esValido == false) {
                                posX = 0;
                                posY = 0;
                                System.out.println("Ingrese la fila (0,1,2)");
                                posX = input.nextInt();

                                while (posX < 0 || posX > 2) {
                                    System.out.println("Ingrese una opcion valida (0, 1, 2)");
                                    posX = input.nextInt();
                                }

                                System.out.println("Ingrese la columna (0,1,2)");
                                posY = input.nextInt();
                                System.out.println("");

                                while (posY < 0 || posY > 2) {
                                    System.out.println("Ingrese una opcion valida (0, 1, 2)");
                                    posY = input.nextInt();
                                }

                                esValido = verificarPocisionValida(tablero, posX, posY);

                                if (esValido == true) {
                                    tablero = llenarTableroX(tablero, posX, posY);
                                    imprimir(tablero);
                                    break;
                                }
                                System.out.println("La coordenadas ingresadas ya contienen un valor");
                            }
                            esValido = false;

                            cont++;
                            ganoX = verificarVictoriaX(tablero);
                            gano0 = verificarVictoria0(tablero);
                            if (ganoX) {
                                System.out.println("El jugador es el ganador!");
                                break;
                            } else if (gano0) {
                                System.out.println("La maquina es el ganador!");
                                break;
                            } else if (cont == 9) {
                                System.out.println("El tablero esta lleno! El juego termina en EMPATE!");
                                break;
                            }

                            System.out.println("");
                            System.out.println("Es el turno de 0");
                            tablero = llenarTablero0(tablero);
                            imprimir(tablero);

                            ganoX = verificarVictoriaX(tablero);
                            gano0 = verificarVictoria0(tablero);
                            if (ganoX) {
                                System.out.println("El jugador es el ganador!");
                                break;
                            } else if (gano0) {
                                System.out.println("La maquina es el ganador!");
                                break;
                            }
                            System.out.println("");
                            cont++;

                        }

                        System.out.println("Desea continuar con este programa? (0-SI, 1-NO)");
                        opcion1 = input.nextInt();

                        while (opcion1 < 0 || opcion1 > 1) {
                            System.out.println("Ingrese una opcion valida (0-SI, 1-NO)");
                            opcion1 = input.nextInt();
                        }

                        if (opcion1 == 1) {
                            bandera1 = false;
                        }

                    }
                    break;
                case 2:
                    boolean bandera2 = true;
                    while (bandera2) {
                        int opcion1;

                        System.out.println("Ingrese el tamaño de la matriz");
                        int size2 = input.nextInt();

                        encontrarPuntoSilla(generarIntMatrizAleatoria(size2));
                        System.out.println("Desea continuar con este programa? (0-SI, 1-NO)");
                        opcion1 = input.nextInt();

                        while (opcion1 < 0 || opcion1 > 1) {
                            System.out.println("Ingrese una opcion valida (0-SI, 1-NO)");
                            opcion1 = input.nextInt();
                        }

                        if (opcion1 == 1) {
                            bandera2 = false;
                        }

                        System.out.println("");
                    }

                    break;
                case 3:
                    System.out.println("Saliendo...");
                    bandera = false;
                    break;

                default:
                    throw new AssertionError();
            }

        }

    } /// end main

    public static int[][] generarIntMatrizAleatoria(int size) {
        int[][] matriz = new int[size][size];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int numRandom = random.nextInt(0, 99);
                matriz[i][j] = numRandom;

            }

        }

        return matriz;
    }

    public static void encontrarPuntoSilla(int[][] matriz) {
        System.out.println("este ejercico me dio pensamientos suicidas emilio");

        imprimirInt(matriz);
        int contB = 0;

        for (int i = 0; i < matriz.length; i++) {
            int menor = matriz[i][0];
            int indiceColumna = 0;

            //menor de una fila
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    indiceColumna = j;
                }
            }

            boolean esPuntoSilla = true;

            //menor es mayor en su columna
            for (int k = 0; k < matriz.length; k++) {
                if (matriz[k][indiceColumna] > menor) {
                    esPuntoSilla = false;
                    break;
                }
            }

            if (esPuntoSilla) {
                contB++;
                System.out.println(menor + " es punto de Silla en la posicion (" + i + ", " + indiceColumna + ")");
            }
        }

        if (contB == 0) {
            System.out.println("No hay punto de silla");
        }
    }

    public static void imprimirInt(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 10) {
                    System.out.print(" ");
                }
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static char[][] llenarTableroX(char[][] matriz, int posX, int posY) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[posX][posY] = 'X';
            }
        }

        return matriz;
    }

    public static char[][] llenarTablero0(char[][] matriz) {

        boolean esValido = false;
        while (!esValido) {

            int posX = random.nextInt(0, 3);
            int posY = random.nextInt(0, 3);

            esValido = verificarPocisionValida(matriz, posX, posY);
            if (esValido) {
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        matriz[posX][posY] = '0';
                    }

                }

            }

        }
        return matriz;
    }

    public static char[][] generarTablero(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ' ';
            }
        }
        return matriz;
    }

    public static boolean verificarPocisionValida(char[][] matriz, int posX, int posY) {
        boolean posValida = true;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[posX][posY] != ' ') {
                    posValida = false;
                }
            }
        }

        return posValida;
    }

    public static boolean verificarVictoriaX(char[][] matriz) {
        boolean verificarVictoria = false;
        // 8 ifs por simbolo
        if (matriz[0][0] == 'X' && matriz[1][0] == 'X' && matriz[2][0] == 'X') {  //1
            verificarVictoria = true;
        } else if (matriz[0][1] == 'X' && matriz[1][1] == 'X' && matriz[2][1] == 'X') {  //2
            verificarVictoria = true;
        } else if (matriz[2][2] == 'X' && matriz[1][2] == 'X' && matriz[0][2] == 'X') {  //3
            verificarVictoria = true;
        } else if (matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X') {  //4
            verificarVictoria = true;
        } else if (matriz[1][0] == 'X' && matriz[1][1] == 'X' && matriz[1][2] == 'X') {  //5
            verificarVictoria = true;
        } else if (matriz[2][0] == 'X' && matriz[2][1] == 'X' && matriz[2][2] == 'X') {  //6
            verificarVictoria = true;
        } else if (matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') {  //7
            verificarVictoria = true;
        } else if (matriz[2][0] == 'X' && matriz[1][1] == 'X' && matriz[0][2] == 'X') {  //8
            verificarVictoria = true;
        }
        return verificarVictoria;

    }

    public static boolean verificarVictoria0(char[][] matriz) {
        boolean verificarVictoria = false;
        // 8 ifs por simbolo
        if (matriz[0][0] == '0' && matriz[1][0] == '0' && matriz[2][0] == '0') {  //1
            verificarVictoria = true;
        } else if (matriz[0][1] == '0' && matriz[1][1] == '0' && matriz[2][1] == '0') {  //2
            verificarVictoria = true;
        } else if (matriz[2][2] == '0' && matriz[1][2] == '0' && matriz[0][2] == '0') {  //3
            verificarVictoria = true;
        } else if (matriz[0][0] == '0' && matriz[0][1] == '0' && matriz[0][2] == '0') {  //4
            verificarVictoria = true;
        } else if (matriz[1][0] == '0' && matriz[1][1] == '0' && matriz[1][2] == '0') {  //5
            verificarVictoria = true;
        } else if (matriz[2][0] == '0' && matriz[2][1] == '0' && matriz[2][2] == '0') {  //6
            verificarVictoria = true;
        } else if (matriz[0][0] == '0' && matriz[1][1] == '0' && matriz[2][2] == '0') {  //7
            verificarVictoria = true;
        } else if (matriz[2][0] == '0' && matriz[1][1] == '0' && matriz[0][2] == '0') {  //8
            verificarVictoria = true;
        }
        return verificarVictoria;

    }

    public static void imprimir(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ((i == 0 || i == 1 || i == 2) && (j == 0)) {
                    System.out.print("[");
                }
                if (j == 1 || j == 2) {
                    System.out.print(",");
                }
                System.out.print(matriz[i][j]);
                if ((i == 0 || i == 1 || i == 2) && (j == 2)) {
                    System.out.print("]");
                }
            }
            System.out.println("");
        }
    }

}
