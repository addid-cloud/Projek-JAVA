package com.tutorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n======= MENU GAMBAR =======");
            System.out.println(" | 1. persegi\t\t |");
            System.out.println(" | 2. persegi panjang\t |");
            System.out.println(" | 3. segitiga siku-siku |");
            System.out.println(" | 4. segitiga sama kaki |");
            System.out.println(" | 5. tutup aplikasi\t |");
            System.out.println("===========================\n");

            System.out.print("masukan angka menu : ");
            int menuUser = inputUser.nextInt();
            switch (menuUser) {
                case 1:
                    System.out.println(">>>>> persegi <<<<<");
                    System.out.print("masukan panjang sisi : ");
                    int sisi = inputUser.nextInt();
                    for (int i = 0; i < sisi; i++) {
                        System.out.println("");
                        for (int j = 0; j < sisi; j++) {
                            System.err.print("[]");
                        }
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println(">>>>> persegi panjang <<<<<");
                    System.out.print("masukan panjang sisi : ");
                    int panjang = inputUser.nextInt();
                    System.out.print("masukan lebar sisi : ");
                    int lebar = inputUser.nextInt();
                    for (int i = 0; i < panjang; i++) {
                        System.out.println("");
                        for (int j = 0; j < lebar; j++) {
                            System.err.print("[]");
                        }
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println(">>>>> segitiga siku-siku <<<<<");
                    System.out.print("masukan tingi : ");
                    int tinggi = inputUser.nextInt();
                    for (int i = 0; i < tinggi; i++) {
                        System.out.println("");
                        for (int j = 0; j < tinggi; j++) {
                            if (i >= j) {
                                System.err.print("*");
                            }
                        }
                    }
                    System.out.println("");
                    break;
                case 4:
                    System.out.println(">>>>> segitiga sama kaki <<<<<");
                    System.out.print("masukan tingi : ");
                    tinggi = inputUser.nextInt();
                    for (int i = 0; i < tinggi; i++) {
                        System.out.println();
                        for (int j = 0; j < tinggi + i; j++) {
                            if (j < tinggi - i - 1) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                    }
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("########## TERIMAKASIH ##########");
                    isExit = true;
                    break;
            }
        }

    }
}
