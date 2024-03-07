import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public static List<Makanan> listMakanan = new ArrayList<>();
    public static List<Minuman> listMinuman = new ArrayList<>();
    public static List<Obat> listObat = new ArrayList<>();

    public static void Kategori(int input, Scanner scan){
        if (input != 7) {
            scan.nextLine();
            System.out.println(" ");
            System.out.println("Sebutkan kategori\n1. Makanan\n2. Minuman\n3. Obat\nPilih : ");
            int kategori = scan.nextInt();

            if (kategori == 1) {
                if (input == 1) {
                    ControllerMakanan.tambahMakanan(listMakanan, scan);
                } else if (input == 2) {
                    ControllerMakanan.ubahNamaMakanan(listMakanan, scan);
                } else if (input == 3) {
                    ControllerMakanan.ubahHargaMakanan(listMakanan, scan);
                } else if (input == 4) {
                    ControllerMakanan.ubahJumlahMakanan(listMakanan, scan);
                } else if (input == 5) {
                    ControllerMakanan.hapusMakanan(listMakanan, scan);
                } else if (input == 6) {
                    System.out.println("=================================================");
                    System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
                    System.out.println("=================================================");
                    ControllerMakanan.lihatMakanan(listMakanan, scan);
                }
            } else if (kategori == 2) {
                if (input == 1) {
                    ControllerMinuman.tambahMinuman(listMinuman, scan);
                } else if (input == 2) {
                    ControllerMinuman.ubahNamaMinuman(listMinuman, scan);
                } else if (input == 3) {
                    ControllerMinuman.ubahHargaMinuman(listMinuman, scan);
                } else if (input == 4) {
                    ControllerMinuman.ubahJumlahMinuman(listMinuman, scan);
                } else if (input == 5) {
                    ControllerMinuman.hapusMinuman(listMinuman, scan);
                } else if (input == 6) {
                    System.out.println("=================================================");
                    System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
                    System.out.println("=================================================");
                    ControllerMinuman.lihatMinuman(listMinuman, scan);
                }
            } else if (kategori == 3) {
                if (input == 1) {
                    ControllerObat.tambahObat(listObat, scan);
                } else if (input == 2) {
                    ControllerObat.ubahNamaObat(listObat, scan);
                } else if (input == 3) {
                    ControllerObat.ubahHargaObat(listObat, scan);
                } else if (input == 4) {
                    ControllerObat.ubahJumlahObat(listObat, scan);
                } else if (input == 5) {
                    ControllerObat.hapusObat(listObat, scan);
                } else if (input == 6) {
                    System.out.println("=================================================");
                    System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
                    System.out.println("=================================================");
                    ControllerObat.lihatObat(listObat, scan);
                }
            }
        } else if (input == 7){
            cariProduk(scan);
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

    public static void cariProduk(Scanner scan){
        System.out.println("Tulis nama produk yang dicari");
        String namaProduk = scan.next();

        String hasil = ControllerMakanan.cariMakanan(listMakanan, namaProduk);
        if (hasil != "0") {
            System.out.println("=================================================");
            System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
            System.out.println("=================================================");
            System.out.println(hasil);

            Controller.restart(scan);
        }
        hasil = ControllerMinuman.cariMinuman(listMinuman, namaProduk);
        if (hasil != "0") {
            System.out.println("=================================================");
            System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
            System.out.println("=================================================");
            System.out.println(hasil);

            Controller.restart(scan);
        }
        hasil = ControllerObat.cariObat(listObat, namaProduk);
        if (hasil != "0") {
            System.out.println("=================================================");
            System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
            System.out.println("=================================================");
            System.out.println(hasil);

            Controller.restart(scan);
        } else {
            System.out.println("Barang kosong");
            Controller.restart(scan);
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

    public static void ubahHargaMakanan(List<Makanan> listMakanan, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama makanan : ");
        String namaProduk = scan.next();
        for(Makanan makanan : listMakanan){
            String listMa = makanan.getNama();

            if(listMa.equals(namaProduk)){
                Float hargaLama = makanan.getHarga();
                System.out.println("Harga sebelumny adalah "+hargaLama);
                System.out.print("Harga baru : ");
                Float hargaBaru = scan.nextFloat();
                makanan.setHarga(hargaBaru);

                System.out.print("Harga dari "+namaProduk+" berhasil diubah menjadi "+hargaBaru);
            }
        }
        Controller.restart(scan);
    }
    public static void ubahJumlahMakanan(List<Makanan> listMakanan, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama makanan : ");
        String namaProduk = scan.next();
        for(Makanan makanan : listMakanan){
            String listMa = makanan.getNama();

            if(listMa.equals(namaProduk)){
                System.out.print("Masukan jumlah yang ingin ditambahkan : ");
                int barangTambahan = scan.nextInt();
                makanan.setJumlah(barangTambahan);
                int jumlahBarang = makanan.getJumlah();

                System.out.print("Jumlah dari "+namaProduk+" menjadi "+jumlahBarang);
            }
        }
        Controller.restart(scan);
    }

    public static void hapusMakanan(List<Makanan> listMakanan, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama makanan : ");
        String namaProduk = scan.next();

        for(Makanan makan : listMakanan){
            String listMa = makan.getNama();

            if(listMa.equals(namaProduk)){
                makan.setHapus();
            }
        }

        System.out.print(namaProduk+" berhasil di hapus\n");
        System.out.println("=================================================");
        System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
        System.out.println("=================================================");
        ControllerMakanan.lihatMakanan(listMakanan, scan);
    }

    public static String cariMakanan(List<Makanan> listMakanan, String namaProduk){
        String input = "0";

        for(Makanan makanan : listMakanan){
            String listMa = makanan.getNama();
            if(listMa.equals(namaProduk)){
                input = makanan.toString();
            }
        }
        return input;
    }
}

class ControllerMinuman {
    public static void tambahMinuman(List<Minuman> listMinuman, Scanner scan){
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

            listMinuman.add(new Minuman(nama, harga, jumlah));
        }
        System.out.println("Barang berhasil ditambahkan!\n");

        Controller.restart(scan);
    }

    public static void lihatMinuman(List<Minuman> listMinuman, Scanner scan){
        for(Minuman minuman : listMinuman){
            System.out.println(minuman+"\n");
        }
        Controller.restart(scan);
    }

    public static void ubahNamaMinuman(List<Minuman> listMinuman, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama minuman yang ingin di ubah : ");
        String namaLama = scan.next();
        for(Minuman minuman : listMinuman) {
            String lisMa = minuman.getNama();

            if(lisMa.equals(namaLama)){
                System.out.print("Tulis nama baru : ");
                String namaBaru = scan.next();
                minuman.setNama(namaBaru);

                System.out.print("Nama dari "+namaLama+" berhasil diubah menjadi "+namaBaru);
            }
        }
        Controller.restart(scan);
    }

    public static void ubahHargaMinuman(List<Minuman> listMinuman, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama minuman : ");
        String namaProduk = scan.next();
        for(Minuman minuman : listMinuman){
            String listMi = minuman.getNama();

            if(listMi.equals(namaProduk)){
                Float hargaLama = minuman.getHarga();
                System.out.println("Harga sebelumny adalah "+hargaLama);
                System.out.print("Harga baru : ");
                Float hargaBaru = scan.nextFloat();
                minuman.setHarga(hargaBaru);

                System.out.print("Harga dari "+namaProduk+" berhasil diubah menjadi "+hargaBaru);
            }
        }
        Controller.restart(scan);
    }
    public static void ubahJumlahMinuman(List<Minuman> listMinuman, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama minuman : ");
        String namaProduk = scan.next();
        for(Minuman minuman : listMinuman){
            String listMi = minuman.getNama();

            if(listMi.equals(namaProduk)){
                System.out.print("Masukan jumlah yang ingin ditambahkan : ");
                int barangTambahan = scan.nextInt();
                minuman.setJumlah(barangTambahan);
                int jumlahBarang = minuman.getJumlah();

                System.out.print("Jumlah dari "+namaProduk+" menjadi "+jumlahBarang);
            }
        }
        Controller.restart(scan);
    }

    public static void hapusMinuman(List<Minuman> listMinuman, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama minuman : ");
        String namaProduk = scan.next();

        for(Minuman minuman : listMinuman){
            String listMi = minuman.getNama();

            if(listMi.equals(namaProduk)){
                minuman.setHapus();
            }
        }

        System.out.print(namaProduk+" berhasil di hapus\n");
        System.out.println("=================================================");
        System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
        System.out.println("=================================================");
        ControllerMinuman.lihatMinuman(listMinuman, scan);
    }

    public static String cariMinuman(List<Minuman> listMinuman, String namaProduk){
        String input = "0";

        for(Minuman minuman : listMinuman){
            String listMi = minuman.getNama();
            if(listMi.equals(namaProduk)){
                input = minuman.toString();
            }
        }
        return input;
    }
}

class ControllerObat {
    public static void tambahObat(List<Obat> listObat, Scanner scan){
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

            listObat.add(new Obat(nama, harga, jumlah));
        }
        System.out.println("Barang berhasil ditambahkan!\n");

        Controller.restart(scan);
    }

    public static void lihatObat(List<Obat> listObat, Scanner scan){
        for(Obat obat : listObat){
            System.out.println(obat+"\n");
        }
        Controller.restart(scan);
    }

    public static void ubahNamaObat(List<Obat> listObat, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama obat yang ingin di ubah : ");
        String namaLama = scan.next();
        for(Obat obat : listObat) {
            String lisMa = obat.getNama();

            if(lisMa.equals(namaLama)){
                System.out.print("Tulis nama baru : ");
                String namaBaru = scan.next();
                obat.setNama(namaBaru);

                System.out.print("Nama dari "+namaLama+" berhasil diubah menjadi "+namaBaru);
            }
        }
        Controller.restart(scan);
    }

    public static void ubahHargaObat(List<Obat> listObat, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama obat : ");
        String namaProduk = scan.next();
        for(Obat obat : listObat){
            String listOb = obat.getNama();

            if(listOb.equals(namaProduk)){
                Float hargaLama = obat.getHarga();
                System.out.println("Harga sebelumny adalah "+hargaLama);
                System.out.print("Harga baru : ");
                Float hargaBaru = scan.nextFloat();
                obat.setHarga(hargaBaru);

                System.out.print("Harga dari "+namaProduk+" berhasil diubah menjadi "+hargaBaru);
            }
        }
        Controller.restart(scan);
    }
    public static void ubahJumlahObat(List<Obat> listObat, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama obat : ");
        String namaProduk = scan.next();
        for(Obat obat : listObat){
            String listOb = obat.getNama();

            if(listOb.equals(namaProduk)){
                System.out.print("Masukan jumlah yang ingin ditambahkan : ");
                int barangTambahan = scan.nextInt();
                obat.setJumlah(barangTambahan);
                int jumlahBarang = obat.getJumlah();

                System.out.print("Jumlah dari "+namaProduk+" menjadi "+jumlahBarang);
            }
        }
        Controller.restart(scan);
    }

    public static void hapusObat(List<Obat> listObat, Scanner scan){
        System.out.println("\n===================");
        System.out.print("Nama obat : ");
        String namaProduk = scan.next();

        for(Obat obat : listObat){
            String listOb = obat.getNama();

            if(listOb.equals(namaProduk)){
                obat.setHapus();
            }
        }

        System.out.print(namaProduk+" berhasil di hapus\n");
        System.out.println("=================================================");
        System.out.println("Nama barang\t\t||\tHarga\t\t||\tJumlah");
        System.out.println("=================================================");
        ControllerObat.lihatObat(listObat, scan);
    }

    public static String cariObat(List<Obat> listObat, String namaProduk){
        String input = "0";

        for(Obat obat : listObat){
            String listOb = obat.getNama();
            if(listOb.equals(namaProduk)){
                input = obat.toString();
            }
        }
        return input;
    }
}