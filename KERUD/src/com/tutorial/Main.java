package com.tutorial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        File database = new File("database.txt");
        FileReader fileReader = new FileReader(database);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        tampilkanData();

    }

    public static void tampilkanData() throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferedReader = new BufferedReader(fileInput);
        System.out.println("\n|NO\t|Nama\t\t\t|NO. WA|\t|Jurusan\t|Tahun\t|");
        System.out.println("-------------------------------------------------");
        String data = bufferedReader.readLine();
        int noData = 0;
        while (data != null) {
            noData++;
            StringTokenizer stringToken = new StringTokenizer(data, ";");
            System.out.printf("|%2d    ", noData);
            System.out.printf("|\t%2s", stringToken.nextToken());
            System.out.printf("|\t%4s ", stringToken.nextToken());
            System.out.printf("|\t%4s ", stringToken.nextToken());
            System.out.printf("|\t%4s ", stringToken.nextToken());
            System.out.println("");
            data = bufferedReader.readLine();
        }
    }
}
