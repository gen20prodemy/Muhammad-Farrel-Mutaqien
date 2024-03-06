import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scan = new Scanner(System.in);
        int menu =0;

        System.out.println("\nStock Gudang warung");
        System.out.println("===================");
        System.out.println("1. Tambah barang");
        System.out.println("2. Ubah nama barang");
        System.out.println("3. Ubah harga barang");
        System.out.println("4. Ubah Stock barang");
        System.out.println("5. Hapus barang");
        System.out.println("6. Lihat Barang");
        System.out.println("7. Cari barang");
        System.out.print("Pilih : ");

        menu = scan.nextInt();

        if(menu!=0){
            Controller.Kategori(menu, scan);
        }
    }
}