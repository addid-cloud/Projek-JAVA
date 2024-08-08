package CRUD;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Operasi {
    public static void deleteData() throws IOException {
        //ambil db ori
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        //buat db tmp
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        //tampil data
        System.out.println("data db");
        tampilkanData();

        //ambil user input data
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n masukan nomer buku yang akan dihapus = ");
        int deleteNum = terminalInput.nextInt();

        //looping baca tiap baris dan skip data yang akan di delete
        boolean isFound =false;
        int entryCounts = 0;
        String data = bufferedInput.readLine();

        while (data != null) {
            entryCounts++;
            boolean isDelete = false;
            StringTokenizer st = new StringTokenizer(data,",");

            //tampilkan data yang ingin dihapus
            if(deleteNum == entryCounts){
                System.out.println("data yang ingin anda hapus : ");
                System.out.println("--------------------------------");
                System.out.println("Referensi      : "+st.nextToken());
                System.out.println("Tahun          : "+st.nextToken());
                System.out.println("Penulis        : "+st.nextToken());
                System.out.println("Penerbit       : "+st.nextToken());
                System.out.println("judul          : "+st.nextToken());

                isDelete = Utils.getYorN("apakah anda yakin mendelete data ?");
                isFound = true;
            }
            if(isDelete){
                //skip pindahkan ori ke tmp
                System.out.println("data berhasil dihapus");
            }else{
                //pindah ori ke tmp
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }
        if(!isFound){
            System.err.println("data tidak ditemukan!");
        }
        //menulis data ke file
        bufferedOutput.flush();
        //delete ori file
        bufferedOutput.close();
        fileOutput.close();
        bufferedInput.close();
        fileInput.close();
        System.gc();
        java.nio.file.Files.delete(database.toPath());
        database.delete();
        tempDB.renameTo(database);

    }
    public static void tampilkanData() throws IOException {

        FileReader fileInput;
        BufferedReader bufferInput;

        try{
            fileInput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileInput);

        }catch (Exception e){
            System.err.println("data base tidak ditemukan");
            System.err.println("silahkan tambah data terlebih dahulu");
            tambahData();
            return;
        }
        System.out.println("\n| No |\tTahun |\tPenulis                |\tPenerbit               |\tJudul Buku ");
        System.out.println("----------------------------------------------------------------------------------");
        String data = bufferInput.readLine();
        int noData = 0;
        while (data != null) {
            noData++;
            StringTokenizer stringToken = new StringTokenizer(data, ",");
            stringToken.nextToken();
            System.out.printf("| %2d ", noData);
            System.out.printf("|\t%4s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%s   ", stringToken.nextToken());
            System.out.println("");
            data = bufferInput.readLine();
        }

        System.out.println("----------------------------------------------------------------------------------");

    }
    public static void tambahData() throws IOException{
        FileWriter fileOutput = new FileWriter("database.txt",true);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);
        // ambil input dari user
        Scanner terminalInput = new Scanner(System.in);
        String penulis,judul,penerbit,tahun;
        System.out.print("masukan nama penulis = ");
        penulis = terminalInput.nextLine();
        System.out.print("masukan judul buku = ");
        judul = terminalInput.nextLine();
        System.out.print("masukan nama penerbit = ");
        penerbit = terminalInput.nextLine();
        System.out.print("masukan tahun terbit = ");
        tahun = Utils.ambilTahun();

        //cek buku di db
        String keywords[] ={tahun+","+penulis+","+penerbit+","+judul};

        boolean isExist = Utils.cekItemDB(keywords,false);
        //write to db
        if(!isExist){
            long nomerEntry = Utils.ambilNoEntryTahun(penulis,tahun) +1;
            String penulisWOSpace =  penulis.replaceAll("\\s+","");
            String primaryKey = penulisWOSpace + "_" + tahun + "_"+nomerEntry;
            System.out.println("\n data yang akan anda masukan adalah = ");
            System.out.println("-------------------------------------------");
            System.out.println("primary key     = "+primaryKey);
            System.out.println("tahun terbit    = "+tahun);
            System.out.println("penulis         = "+penulis);
            System.out.println("judul buku      = "+judul);
            System.out.println("penerbit buku   = "+penerbit);

            boolean isTambah = Utils.getYorN("apakah anda ingin menambahkan data tersebut ? ");

            if (isTambah){
                bufferedOutput.write(primaryKey+","+tahun+","+penulis+","+penerbit+","+judul);
                bufferedOutput.newLine();
                bufferedOutput.flush();
            }

        }else{
            System.out.println("buku yang anda tambahkan sudah tersedia");
            Utils.cekItemDB(keywords,true);
        }
        bufferedOutput.close();
        fileOutput.close();
    }
    public static void cariData() throws IOException{
        //membaca db ada / tidak

        try{
            File file = new File("database.txt");
        }catch (Exception e){
            System.err.println("data base tidak ditemukan");
            System.err.println("silahkan tambah data terlebih dahulu");
            tambahData();
            return;
        }

        //ambil keyword user

        Scanner userInput = new Scanner(System.in);
        System.out.print("masukan kata kunci untuk mencari buku = ");
        String cariString = userInput.nextLine();
        System.out.println(cariString);
        String[] keywords = cariString.split("\\s+");


        //cek keyword database
        Utils.cekItemDB(keywords,true);


    }
    public static void updateData() throws IOException{
        // ambil sb ori
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput =new BufferedReader(fileInput);

        //buat db tmp
        File tmpDB = new File("tmpDB.txt");
        FileWriter fileOutput = new FileWriter(tmpDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);
        // tampilkan data
        System.out.println("list item : ");
        tampilkanData();
        //ambil user input
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("masukan nomer list yang akan diupdate : ");
        int updateNum = terminalInput.nextInt();

        //tampilkan data yang diupdate
        String data = bufferedInput.readLine();
        int entryCounts = 0;
        while(data != null){
            entryCounts++;
            StringTokenizer st = new StringTokenizer(data, ",");
            //tampilkan entry counts == updateNum
            if(entryCounts == updateNum){
                System.out.println("\n data yang ingin diganti adalah : ");
                System.out.println("-------------------------------------------");
                System.out.println("Referensi      : "+st.nextToken());
                System.out.println("Tahun          : "+st.nextToken());
                System.out.println("Penulis        : "+st.nextToken());
                System.out.println("Penerbit       : "+st.nextToken());
                System.out.println("judul          : "+st.nextToken());

                //update data

                // mengambil input dari user
                String[] fieldData = {"tahun","penulis","penerbit","judul"};
                String[] tmpData = new String[4];

                st = new StringTokenizer(data,",");
                String originalData = st.nextToken();


                for(int i=0;i< fieldData.length;i++) {
                    boolean isUpdate = Utils.getYorN("apakah anda ingin merubah " + fieldData[i]);
                    originalData = st.nextToken();
                    if(isUpdate){
                        if (fieldData[i].equalsIgnoreCase("tahun")){
                            System.out.print("masukan tahun terbit, format=(YYYY): ");
                            tmpData[i] = Utils.ambilTahun();
                        }else {
                            terminalInput = new Scanner(System.in);
                            System.out.print("\n masukan " + fieldData[i] + " baru: ");
                            tmpData[i] = terminalInput.nextLine();
                        }
                    }else{
                        tmpData[i] = originalData;

                    }
                }

                //tampilkan data baru ke layar
                st = new StringTokenizer(data,",");
                st.nextToken();
                System.out.println("\n data baru anda adalah : ");
                System.out.println("-------------------------------------------");
                System.out.println("Tahun          : "+st.nextToken() + "--->" + tmpData[0]);
                System.out.println("Penulis        : "+st.nextToken() + "--->" + tmpData[1]);
                System.out.println("Penerbit       : "+st.nextToken() + "--->" + tmpData[2]);
                System.out.println("judul          : "+st.nextToken() + "--->" + tmpData[3]);


                boolean isUpdate = Utils.getYorN("apakah anda yakin ingin mengupdate data tersebut");
                if(isUpdate){
                    //cek data baru di db
                    boolean isExist = Utils.cekItemDB(tmpData,false);
                    if(isExist){
                        System.err.println("data buku sudah ada di database, prosess update dibatalkan");
                        bufferedOutput.write(data);
                        bufferedOutput.newLine();
                    }else{
                        //format data baru ke db
                        String tahun = tmpData[0];
                        String penulis = tmpData[1];
                        String penerbit = tmpData[2];
                        String judul  = tmpData[3];
                        //primary key
                        long nomerEntry = Utils.ambilNoEntryTahun(penulis,tahun) +1;
                        String penulisWOSpace =  penulis.replaceAll("\\s+","");
                        String primaryKey = penulisWOSpace + "_" + tahun + "_"+nomerEntry;


                        //tulis data ke db
                        bufferedOutput.write(primaryKey+","+tahun+","+penulis+","+penerbit+","+judul);
                    }
                }else{
                    bufferedOutput.write(data);
                }

            }else{
                //copy data
                bufferedOutput.write(data);
            }
            bufferedOutput.newLine();
            data = bufferedInput.readLine();
        }
        //menulis data ke file
        bufferedOutput.flush();
        //delete ori
        bufferedOutput.close();
        fileOutput.close();
        bufferedInput.close();
        fileInput.close();
        System.gc();
        java.nio.file.Files.delete(database.toPath());
        database.delete();
        tmpDB.renameTo(database);

        //rename file
    }
}
