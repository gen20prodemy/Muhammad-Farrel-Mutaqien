package Main;

import java.util.Scanner;

import POJO.DataTiket;
import Interface.Interface;
import CRUD.CRUD;

public class Main {
    public static CRUD crud = new CRUD();
    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        Scanner scan = new Scanner(System.in);
        int menu = 0;

        System.out.println("====================");
        System.out.println("\tMenu Utama");
        System.out.println("====================");
        System.out.println("1. Memasukan data tiket");
        System.out.println("2. Melihat data tiket");
        System.out.println("3. Mengubah data tiket");
        System.out.println("4. Menghapus data tiket");
        System.out.println("5. Mengubah tiket menjadi file txt");
        System.out.println("6. Membaca tiket dari file txt");
        System.out.println("7. Keluar");
        System.out.print("Pilih : ");
        menu = scan.nextInt();

        switch (menu){
            case 1:
                tambahTiket(crud,scan);
                break;

            case 2:
                crud.tampilkanData();
                restart(scan);
                break;

            case 3:
                updateTiket(crud,scan);
                break;

            case 4:
                hapusTiket(crud,scan);
                break;

            case 5:
                crud.cetakData();
                restart(scan);
                break;

            case 6:
                crud.bacaData();
                restart(scan);
                break;

            case 7:
                System.exit(1);
                break;
        }
    }

    public static void restart (Scanner scan){
        System.out.print("\n1. Keluar\n2. Kembali ke menu utama\nPilih : ");
        int temp = scan.nextInt();
        System.out.print("\n");

        if (temp == 2){
            menu();
        }
    }

    public static void tambahTiket(Interface crud, Scanner scan){
        System.out.print("Jumlah input : ");
        int Input = scan.nextInt();

        for(int i=0; i<Input; i++){
            System.out.print("Tulis kode tiket : ");
            int kode = scan.nextInt();

            scan.nextLine();
            System.out.print("Tulis nama pelanggan : ");
            String nama = scan.nextLine();

            DataTiket tambah = new DataTiket(kode, nama);
            crud.tambahData(tambah);
        }
        restart(scan);
    }

    public static void updateTiket(Interface crud, Scanner scan){
        System.out.print("Tulis kode tiket : ");
        int kode = scan.nextInt();
        scan.nextLine();

        System.out.print("Tulis nama custommer : ");
        String input = scan.nextLine();

        DataTiket update = new DataTiket(kode,input);
        crud.updateData(update);

        restart(scan);
    }

    public static void hapusTiket(Interface crud, Scanner scan){
        System.out.print("Tulis kode tiket yang ingin di hapus : ");
        int kode = scan.nextInt();
        scan.nextLine();

        DataTiket delete = new DataTiket(kode, null);
        crud.hapusData(delete);
        restart(scan);
    }
}
