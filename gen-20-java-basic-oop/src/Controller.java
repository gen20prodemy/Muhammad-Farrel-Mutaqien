import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static List<Makanan> listMakanan = new ArrayList<>();
    public static List<Minuman> listMinuman = new ArrayList<>();
    public static List<Obat> listObat = new ArrayList<>();

    public static void Kategori(int input, Scanner scan){
        scan.nextLine();
        System.out.println(" ");
        System.out.println("Sebutkan kategori\n1. Makanan\n2. Minuman\n3. Obat\nPilih : ");
        int kategori = scan.nextInt();

        if(kategori == 1){
            if(input == 1) {
                ControllerMakanan.tambahMakanan(listMakanan, scan);
            }else if (input == 2){
                ControllerMakanan.ubahNamaMakanan(listMakanan, scan);
            }else if (input == 6){
                System.out.println("=================================================");
                System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
                System.out.println("=================================================");
                ControllerMakanan.lihatMakanan(listMakanan, scan);
            }
        }
    }

    public static void restart (Scanner scan){
        int restarting = 0;
        System.out.print("\n1. Keluar\n2. Kembali ke menu utama\nPilih : ");
        int temp = scan.nextInt();
        System.out.print("\n");

        if (temp == 2){
            Main.menu();
        }
    }
}

class ControllerMakanan {
    public static void tambahMakanan(List<Makanan> listMakanan, Scanner scan){
        System.out.print("Jumlah input : ");
        int Input = scan.nextInt();

        for(int i=0; i<Input; i++) {
            System.out.println("\n===================");
            scan.nextLine();
            System.out.print("Masukan nama : ");
            String nama = scan.nextLine();

            System.out.print("Masukan harga : ");
            float harga = scan.nextFloat();

            System.out.print("Masukan jumlah : ");
            int jumlah = scan.nextInt();

            listMakanan.add(new Makanan(nama, harga, jumlah));
        }
        System.out.println("Barang berhasil ditambahkan!\n");

        Controller.restart(scan);
    }

    public static void lihatMakanan(List<Makanan> listMakanan, Scanner scan){
        for(Makanan makanan : listMakanan){
            System.out.println(makanan+"\n");
        }
        Controller.restart(scan);
    }

    public static void ubahNamaMakanan(List<Makanan> listMakanan, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama makanan yang ingin di ubah : ");
        String namaLama = scan.next();
        for(Makanan makanan : listMakanan) {
            String lisMa = makanan.getNama();

            if(lisMa.equals(namaLama)){
                System.out.print("Tulis nama baru : ");
                String namaBaru = scan.next();
                makanan.setNama(namaBaru);

                System.out.print("Nama dari "+namaLama+" berhasil diubah menjadi "+namaBaru);
            }
        }
        Controller.restart(scan);
    }
}