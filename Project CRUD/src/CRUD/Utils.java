package CRUD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utils {
    static String ambilTahun() throws IOException {
        boolean tahunValid = false;
        Scanner terminalInput = new Scanner(System.in);
        String tahunInput = terminalInput.nextLine();
        while (!tahunValid) {
            try {
                Year.parse(tahunInput);
                tahunValid = true;
            } catch (Exception e) {
                System.out.println("\ntahun salah sam");
                System.out.print("masukan tahun terbit lagi = ");
                tahunInput = terminalInput.nextLine();
                tahunValid = false;
            }
        }
        return tahunInput;
    }
    static boolean cekItemDB(String[] keywords, boolean isDisplay) throws IOException{
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false;
        int noData =0;
        if(isDisplay) {
            System.out.println("\n| No |\tTahun |\tPenulis                |\tPenerbit               |\tJudul Buku ");
            System.out.println("----------------------------------------------------------------------------------");
        }
        while (data != null){
            //cek keyword
            isExist = true;

            for(String keyword : keywords){
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            //if keywordnya cocok = tampilkan
            if(isExist){
                if (isDisplay) {
                    StringTokenizer stringToken = new StringTokenizer(data, ",");
                    stringToken.nextToken();
                    noData++;
                    System.out.printf("| %2d ", noData);
                    System.out.printf("|\t%4s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%s   ", stringToken.nextToken());
                    System.out.println("");
                }else {
                    break;
                }
            }


            data = bufferInput.readLine();
        }
        if (isDisplay){
            System.out.println("----------------------------------------------------------------------------------");
        }
        fileInput.close();
        bufferInput.close();
        return isExist;
    }
    static long ambilNoEntryTahun(String penulis,String tahun) throws IOException{
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferedInput = new BufferedReader(fileInput);
        long entry =0;
        String data = bufferedInput.readLine();
        Scanner dataScanner;
        String primaryKey;
        while (data!=null){
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primaryKey = dataScanner.next();
            dataScanner = new Scanner(primaryKey);
            dataScanner.useDelimiter("_");
            penulis  = penulis.replaceAll("\\s+","");
            if(penulis.equalsIgnoreCase(dataScanner.next()) && tahun.equalsIgnoreCase(dataScanner.next())){
                entry = dataScanner.nextInt();
            }
            data =bufferedInput.readLine();
        }
        return entry;

    }
    public static boolean getYorN(String massage){
        Scanner userOption  = new Scanner(System.in);
        System.out.println("\n" + massage + "[y/n] ? ");
        String pilihanUser = userOption.next();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("pilihan anda bukan y atau n");
            System.out.println("\n" + massage + "[y/n] ? ");
            pilihanUser = userOption.next();
        }
        return pilihanUser.equalsIgnoreCase("y");
    }
    public static void clearScreen(){
        try{
            if (System.getProperty("os.name").toLowerCase().contains("windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\003\143");
            }
        }catch (Exception e){
            System.err.println("tidak bisa clear screen");
        }
    }
}
