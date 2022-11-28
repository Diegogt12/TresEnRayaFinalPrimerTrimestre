package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] tablero= new char[3][3];
        int[] turno = new int[1];
        int[] posicion = new int[2];
        int jugador;
        int victoria1 = 0;
        int victoria2 = 0;
        char reStart = ' ';

        while (reStart != 'S') {
            turno[0] = 0;
            vaciarTablero(tablero);

            while ((!partidaGanada(tablero)) && (turno[0]) < 9) {
                turno[0]++;
                verTablero(tablero);
                pedirPosicion(posicion, turno);
                if (comprobarPosicionLibre(tablero, posicion)) {
                    rellenarTablero(tablero, turno, posicion);
                }
                else {
                    System.out.println(" ");
                    System.out.println("Posicion ocupada, intentelo de nuevo ");
                    System.out.println(" ");
                    turno[0]--;
                }

            }

            verTablero(tablero);
            jugador = comprobarJugador(turno);

            if(partidaGanada(tablero)) {
                System.out.println(" ");
                System.out.println("Ganador el jugador " + jugador);
                if(jugador == 1) victoria1++;
                else victoria2++;
            }
            else {
                System.out.println(" ");
                System.out.println("Partida terminada sin ganador");
            }
            System.out.println(" ");
            System.out.println("Victorias del jugador 1 : " + victoria1);
            System.out.println("Victorias del jugador 2 : " + victoria2);
            System.out.println(" ");
            System.out.println("Pulse cualquier tecla para volver a jugar");
            System.out.println("O pulse 'S' para terminar ");

            Scanner sc = new Scanner(System.in);
            reStart = sc.next().charAt(0);
            reStart = Character.toUpperCase(reStart);

        }
    }

    public static void vaciarTablero (char[][] tablero){
        for (int x=0; x < tablero.length; x++) {
            for (int y=0; y < tablero[x].length; y++) {
                tablero [x][y] = '_';
            }
        }
    }

    public static void verTablero(char[][] tablero) {
        for (int x = 0; x < tablero.length; x++) {
            System.out.println(" ");
            for (int y = 0; y < tablero[x].length; y++) {
                System.out.print(tablero[x][y] + " ");
            }
        }
        System.out.println(" ");
    }

    public static void pedirPosicion(int [] posicion, int [] turno) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fila jugador " + comprobarJugador(turno) + " : ");
        posicion[0] = sc.nextInt() - 1;
        while (( posicion [0] < 0) || (posicion[0] > 2)){
            System.out.println("Esta fila no existe, intentelo de nuevo ");
            System.out.print("Fila jugador " + comprobarJugador(turno) + " : ");
            posicion[0] = sc.nextInt() - 1;
        }

        System.out.print("Columna jugador " + comprobarJugador(turno) + " : ");
        posicion[1] = sc.nextInt() - 1;
        while (( posicion [1] < 0) || (posicion[1] > 2)){
            System.out.println("Esta columna no existe, intentelo de nuevo ");
            System.out.print("Columna jugador "+ comprobarJugador(turno) + " : ");
            posicion[1] = sc.nextInt() - 1;
        }
    }

    public static boolean comprobarPosicionLibre(char[][] tablero, int[] posicion){
        int x = posicion[0];
        int y = posicion [1];
        if (tablero[x][y] == '_') return true;
        else return false;
    }

    public static void rellenarTablero(char[][] tablero, int[] turno, int[] posicion) {
        int x = posicion[0];
        int y = posicion [1];
        char ficha1 = 'X';
        char ficha2 = 'O';
        if(turno[0] %2 != 0) tablero[x][y] = ficha1;
        else tablero[x][y] = ficha2;
    }

    public static boolean partidaGanada(char[][] tablero){
        if ((tablero[0][0]== tablero[0][1]) && (tablero[0][0] == tablero[0][2]) && (tablero[0][0]!= '_')) return true;
        if ((tablero[1][0]== tablero[1][1]) && (tablero[1][0] == tablero[1][2]) && (tablero[1][0]!= '_')) return true;
        if ((tablero[2][0]== tablero[2][1]) && (tablero[2][0] == tablero[2][2]) && (tablero[2][0]!= '_')) return true;
        if ((tablero[0][0]== tablero[1][1]) && (tablero[0][0] == tablero[2][2]) && (tablero[0][0]!= '_')) return true;
        if ((tablero[0][2]== tablero[1][1]) && (tablero[0][2] == tablero[2][0]) && (tablero[0][2]!= '_')) return true;
        if ((tablero[0][0]== tablero[1][0]) && (tablero[0][0] == tablero[2][0]) && (tablero[0][0]!= '_')) return true;
        if ((tablero[0][1]== tablero[1][1]) && (tablero[0][1] == tablero[2][1]) && (tablero[0][1]!= '_')) return true;
        if ((tablero[0][2]== tablero[1][2]) && (tablero[0][2] == tablero[2][2]) && (tablero[0][2]!= '_')) return true;

        return false;
    }

    private static int comprobarJugador(int[] turno) {
        int jugador;
        if (turno[0] % 2 == 0) jugador = 2;
        else jugador = 1;

        return jugador;
    }
}
