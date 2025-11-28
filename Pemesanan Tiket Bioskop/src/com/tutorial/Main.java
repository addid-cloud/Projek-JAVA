package com.tutorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tiket spyXfamily = new Tiket("spy x family");
        Tiket haikyuu = new Tiket("Haikyuu");
        Tiket apostle = new Tiket("Apostle");
        Tiket[] kumpulanTiket = { spyXfamily, haikyuu, apostle };
        spyXfamily.setJam(new String[] { "12:30", "20:10", "22:00" });
        apostle.setJam(new String[] { "10:30", "18:10", "23:00" });
        haikyuu.setJam(new String[] { "11:30", "19:10", "21:00" });
        spyXfamily.setHarga(100000);
        haikyuu.setHarga(90000);
        apostle.setHarga(90000);
        String[] kode = new String[10];
        for (int i = 1; i <= 9; i++) {
            kode[i] = "A00" + i;
        }
        apostle.setKode(kode);
        haikyuu.setKode(kode);
        spyXfamily.setKode(kode);

        System.out.println("==================================================");
        System.out.println(" #\t\tMENU TIKET BIOSKOP\t\t# ");
        System.out.println("==================================================");
        System.out.println(" |\t\t 1. spy x family \t\t|");
        System.out.println(" |\t\t 2. haikyuu \t\t\t|");
        System.out.println(" |\t\t 3. apostle \t\t\t|");
        System.out.println("==================================================");
        System.out.print("masukan tiket yang anda pilih : ");
        Scanner inputUser = new Scanner(System.in);
        int inputTiket = inputUser.nextInt();
        if (inputTiket == 1) {
        }

    }
}
