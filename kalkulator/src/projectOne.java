import java.util.Scanner;

public class projectOne {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        int menu = 0;
        do {

            System.out.println("===== MENU =====");
            System.out.println("1. data sederhana");
            System.out.println("2. kalkulator");
            System.out.println("3. perbandingan");
            System.out.println("4. exit");
            System.out.println("");
            System.out.print("masukan angka yang anda pilih : ");
            menu = inputUser.nextInt();

            if (menu == 1) {
                System.out.println("1. indonesia merdeka pada 17 agustus 1945");
                System.out.println("2. makan mie ayam enaknya sama es teh");
                System.out.println("3. besok saya menjadi developer google ");
            } else if (menu == 2) {
                System.out.println("===== KALKULATOR =====");
                System.out.println("1. Penjumlahan");
                System.out.println("2. Pengurangan");
                System.out.println("3. Perkalian");
                System.out.println("4. Pembagian");
                System.out.println("5. modulo");
                System.out.println("");
                System.out.print("masukan angka yang anda pilih : ");
                int menuKalkulator = inputUser.nextInt();
                System.out.print("masukan angka pertama : ");
                int angkaPertama = inputUser.nextInt();
                System.out.print("masukan angka kedua : ");
                int angkaKedua = inputUser.nextInt();
                switch (menuKalkulator) {
                    case 1:
                        System.out.println(angkaPertama + " + " + angkaKedua + " = " + (angkaPertama + angkaKedua));
                        break;
                    case 2:
                        System.out.println(angkaPertama + " - " + angkaKedua + " = " + (angkaPertama - angkaKedua));
                        break;
                    case 3:
                        System.out.println(angkaPertama + " * " + angkaKedua + " = " + (angkaPertama * angkaKedua));
                        break;
                    case 4:
                        System.out.println(angkaPertama + " / " + angkaKedua + " = " + (angkaPertama / angkaKedua));
                        break;
                    case 5:
                        System.out.println(angkaPertama + " % " + angkaKedua + " = " + (angkaPertama % angkaKedua));
                        break;
                    default:
                        System.out.println("isikan dengan angka yang sesuai kalkulator");
                        break;

                }
            } else if (menu == 3) {
                System.out.println("===== PERBANDINGAN =====");
                System.out.print("masukan angka pertama : ");
                int angkaPertama = inputUser.nextInt();
                System.out.print("masukan angka kedua : ");
                int angkaKedua = inputUser.nextInt();
                if (angkaPertama > angkaKedua) {
                    System.out.println(angkaPertama + " itu lebih dari " + angkaKedua);
                } else if (angkaPertama == angkaKedua) {
                    System.out.println(angkaPertama + " itu sama dengan " + angkaKedua);
                } else {
                    System.out.println(angkaPertama + " itu sama dengan " + angkaKedua);
                }
            } else if (menu == 4) {
                System.out.println("program selesai");
            } else {
                System.out.println("maaf nomer anda yang pilih tidak ada di menu");
            }
        } while (menu != 4);
    }
}
