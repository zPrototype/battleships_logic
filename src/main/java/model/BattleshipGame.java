package model;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        int SpielfeldLaenge = 10;
        char wasser = '-';
        char schiff = 's';
        char getroffen = 'X';
        char verschossen = '0';
        int schiffNummer = 5;

        char[][] Spielfeld = createSpielfeld(SpielfeldLaenge, wasser, schiff, schiffNummer);
        printSpielfeld(Spielfeld, wasser, schiff);
        int undetectedschiffNummer = schiffNummer;
        while (undetectedschiffNummer > 0) {
            int[] guessKoordinaten = getUserKoordinaten(SpielfeldLaenge);
            char locationUpdate = SchaetzeGuessAbUndErhalteZiel(guessKoordinaten, Spielfeld, schiff, wasser, getroffen, verschossen);
            if (locationUpdate == getroffen) {
                undetectedschiffNummer--;
            }
            Spielfeld = updateSpielfeld(Spielfeld, guessKoordinaten, locationUpdate);
            printSpielfeld(Spielfeld, wasser, schiff);

        }
    }

    private static char[][] updateSpielfeld(char[][] Spielfeld, int[] guessKoordinaten, char locationUpdate) {
        int reihe = guessKoordinaten[0];
        int spalte = guessKoordinaten[1];
        Spielfeld[reihe][spalte] = locationUpdate;
        return Spielfeld;
    }

    private static char SchaetzeGuessAbUndErhalteZiel(int[] guessKoordinaten, char[][] Spielfeld, char schiff, char wasser, char getroffen, char verschossen) {
        int row = guessKoordinaten[0];
        int col = guessKoordinaten[1];
        char target = Spielfeld[row][col];
        String message;
        if (target == schiff) {
            message = "Getroffen!";
            target = getroffen;
        } else if (target == wasser) {
            message = "Verschossen!";
            target = verschossen;
        } else {
            message = "Bereits getroffen!";
        }
        System.out.println(message);
        return target;
    }

    private static int[] getUserKoordinaten(int SpielfeldLänge) {
        int reihe;
        int spalte;
        do {
            System.out.print("Reihe: ");
            reihe = new Scanner(System.in).nextInt();
        } while (reihe < 0 || reihe > SpielfeldLänge + 1);
        do {
            System.out.print("Spalte: ");
            spalte = new Scanner(System.in).nextInt();
        } while (spalte < 0 || spalte > SpielfeldLänge + 1);
        return new int[]{reihe - 1, spalte - 1};
    }

    private static void printSpielfeld(char[][] Spielfeld, char wasser, char schiff) {
        int SpielfeldLaenge = Spielfeld.length;
        System.out.print("  ");
        for (int i = 0; i < SpielfeldLaenge; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int reihe = 0; reihe < SpielfeldLaenge; reihe++) {
            System.out.print(reihe + 1 + " ");
            for (int spalte = 0; spalte < SpielfeldLaenge; spalte++) {

                char position = Spielfeld[reihe][spalte];
                if (position == schiff) {
                    System.out.print(wasser + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }

    private static char[][] createSpielfeld(int SpielfeldLaenge, char wasser, char schiff, int schiffNummer) {
        char[][] Spielfeld = new char[SpielfeldLaenge][SpielfeldLaenge];
        for (char[] reihe : Spielfeld) {
            Arrays.fill(reihe, wasser);
        }
        return platziereSchiffe(Spielfeld, schiffNummer, wasser, schiff);
    }

    private static char[][] platziereSchiffe(char[][] Spielfeld, int schiffNummer, char wasser, char schiff) {
        int platziereSchiffe = 0;
        int SpielfeldLaenge = Spielfeld.length;
        while (platziereSchiffe < schiffNummer) {
            int[] location = generateSchiffKoordinaten(SpielfeldLaenge);

            char moeglichePlatzierung = Spielfeld[location[0]][location[1]];
            if (moeglichePlatzierung == wasser) {
                Spielfeld[location[0]][location[1]] = schiff;
                platziereSchiffe++;
            }
        }
        return Spielfeld;
    }

    private static int[] generateSchiffKoordinaten(int SpielfeldLaenge) {
        int[] Koordinaten = new int[2];
        for (int i = 0; i < Koordinaten.length; i++) {
            Koordinaten[i] = new Random().nextInt(SpielfeldLaenge);
        }
        return Koordinaten;
    }
}
