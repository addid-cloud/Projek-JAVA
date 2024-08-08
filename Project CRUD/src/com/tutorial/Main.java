package com.tutorial;

import CRUD.Operasi;
import CRUD.Utils;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException{
        Scanner userOption  = new Scanner(System.in);
        Boolean isLanjutkan = true;
        while (isLanjutkan){
        Utils.clearScreen();
        System.out.println("=============================");
        System.out.println("Database Perpustakaan");
        System.out.println("1.\t lihat seluruh buku");
        System.out.println("2.\t cari data buku");
        System.out.println("3.\t tambah data buku");
        System.out.println("4.\t ubah data buku");
        System.out.println("5.\t delete data buku");
        System.out.println("=============================");
        System.out.print("\n Pilihan anda = ");
        String pilihanUser = userOption.next();

        switch (pilihanUser){
            case "1":
                System.out.println("\n#################");
                System.out.println("LIST SELURUH BUKU");
                System.out.println("#################");
                //tampilkan data
                Operasi.tampilkanData();
                break;
            case "2":
                System.out.println("\n#########");
                System.out.println("CARI BUKU");
                System.out.println("#########");
                //cari data
                Operasi.cariData();
                break;
            case "3":
                System.out.println("\n################");
                System.out.println("TAMBAH DATA BUKU");
                System.out.println("################");
                //tambah data
                Operasi.tambahData();
                Operasi.tampilkanData();
                break;
            case "4":
                System.out.println("\n##############");
                System.out.println("UBAH DATA BUKU");
                System.out.println("##############");
                //ubah data
                Operasi.updateData();
                break;
            case "5":
                System.out.println("\n################");
                System.out.println("DELETE DATA BUKU");
                System.out.println("################");
                //hapus data
                Operasi.deleteData();
                break;
            default:
                System.err.println("\n input anda tidak ditemukan silahkan pilih 1 - 5");
        }
        isLanjutkan = Utils.getYorN("apakah anda ingin melanjutkan");
        }
    }
}
