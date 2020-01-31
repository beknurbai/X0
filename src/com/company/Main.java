package com.company;


import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int Razmer = 3;
    static final char player = '0';
    static final char bot = 'X';
    static final char Nuul = '!';
    static Scanner vvod = new Scanner(System.in);
    static Random random = new Random();
    static final char[][] pole = new char[Razmer][Razmer];

    public static void main(String[] args) {
        initField();
        print();
        while (true) {
            movePerson();
            print();
            if (chekWin(player)) {
                System.out.println("You win!!!");
                break;
            }
            if (isFreeSpace()) {
                System.out.println("Draw");
                break;
            }
            moveAI();
            System.out.println();
            print();
            if (chekWin(bot)) {
                System.out.println("You lose...");
                break;
            }

        if (isFreeSpace()) {
            System.out.println("Draw");
break;
        }
        }

    }

    {

    }

    static void initField() {
        for (int i = 0; i < Razmer; i++) {
            for (int j = 0; j < Razmer; j++) {
                pole[i][j] = Nuul;

            }

        }

    }

    static void print() {
        for (int i = 0; i < Razmer; i++) {
            for (int j = 0; j < Razmer; j++) {
                System.out.print(pole[i][j] + "\t");
            }
            System.out.println();


        }

    }

    static void setSym(int x, int y, char sym) {
        pole[y][x] = sym;
    }

    static void movePerson() {
        int x, y;
        do {
            x = vvod.nextInt() - 1;
            y = vvod.nextInt() - 1;
        } while (!isCellvaid(x, y));
        pole[y][x] = player;

    }

    static void moveAI() {
        int x, y;
        do {
            x = random.nextInt(Razmer);
            y = random.nextInt(Razmer);

        } while (!isCellvaid(x, y));
        pole[y][x] = bot;
    }


    private static boolean isCellvaid(int x, int y) {
        if (x < 0 || x >= Razmer || y < 0 || y >= Razmer) return false;
        if (pole[y][x] == Nuul) return true;

        return false;


    }

    static boolean isFreeSpace() {
        for (int i = 0; i < Razmer; i++) {
            for (int j = 0; j < Razmer; j++) {
                if (pole[i][j] == Nuul) return false;

            }

        }
        return true;
    }

    static boolean chekWin(char sym) {
        for (int i = 0; i < Razmer; i++) {
            int result = 0;
            for (int j = 0; j < Razmer; j++) {
                if (pole[i][j] == sym) result++;

            }
            if (result == Razmer) return true;

        }
        int first = 0;
        for (int i = 0; i < Razmer; i++) {
            for (int j = 0; j < Razmer; j++) {
                if (j == i && pole[i][j] == sym) first++;
            }
        }
        if (first == Razmer) return true;
        int second = 0;
        for (int i = 0, j = Razmer - 1; i < Razmer && j >= 0; i++, j--) {
            if (pole[i][j] == sym) second++;
        }
        if (second == Razmer) return true;
        return false;


    }
}

