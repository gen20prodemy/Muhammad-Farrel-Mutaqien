package Main;

import java.util.Scanner;

import POJO.Karyawan;
import Interface.InterfaceCRUD;
import MAPCRUD.CRUD;

public class Main {
    public static CRUD crud = new CRUD();
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scan = new Scanner(System.in);
        int menu = 0;

        System.out.println("====================");
        System.out.println("\tMenu Utama");
        System.out.println("====================");
        System.out.println("1. Memasukan data karyawan");
        System.out.println("2. Melihat data karyawan");
        System.out.println("3. Mengubah data karyawan");
        System.out.println("4. Menghapus data karyawan");
        System.out.println("5. Keluar");
        System.out.print("Pilih : ");
        menu = scan.nextInt();

        switch (menu){
            case 1:
                tambahData(crud, scan);
                break;

            case 2:
                crud.tampilkanData();
                restart(scan);
                break;

            case 3:
                ubahData(crud, scan);
                break;

            case 4:
                hapusData(crud, scan);
                break;

            case 5:
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

    public static void tambahData(InterfaceCRUD crud, Scanner scan){
        System.out.print("Jumlah input : ");
        int Input = scan.nextInt();

        for(int i=0; i<Input; i++) {
            System.out.println("\n===================");
            System.out.print("Masukan id : ");
            int id = scan.nextInt();

            scan.nextLine();
            System.out.print("Masukan nama : ");
            String nama = scan.nextLine();

            System.out.print("Masukan departemen : ");
            String departemen = scan.nextLine();

            Karyawan dataBaru = new Karyawan(id, nama, departemen);
            crud.tambahData(dataBaru);
        }
        restart(scan);
    }

    public static void ubahData(InterfaceCRUD crud, Scanner scan){
        System.out.println("\n===================");
        System.out.print("ID karyawan yang ingin di ubah : ");
        int idKaryawan = scan.nextInt();
        System.out.print("Data yang ingin di ubah\n1. Nama\n2. Departemen\nPilih : ");
        int pilihan = scan.nextInt();
        String input = null;

        if (pilihan == 1){
            scan.nextLine();
            System.out.print("Tulis nama baru : ");
            input = scan.nextLine();

            Karyawan update = new Karyawan(idKaryawan,input, null);
            crud.updateNama(update);
        } else if (pilihan == 2){
            scan.nextLine();
            System.out.print("Tulis departemen baru : ");
            input = scan.nextLine();

            Karyawan update = new Karyawan(idKaryawan,null, input);
            crud.updateDepartemen(update);
        }
        restart(scan);
    }

    public static void hapusData(InterfaceCRUD crud, Scanner scan) {
        System.out.println("\n===================");
        System.out.print("ID karyawan yang ingin di ubah : ");
        int idKaryawan = scan.nextInt();


        Karyawan delete = new Karyawan(idKaryawan, null, null);
        crud.hapusData(delete);
        restart(scan);
    }
}