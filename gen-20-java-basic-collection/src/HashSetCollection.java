import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class HashSetCollection {
        public static HashSet<listDataKaryawan> setKaryawan = new HashSet<>();
    public static void main(String[] args) {

//        DataDefault(setKaryawan);
        Beranda();
    }

    public static void Beranda(){
        Scanner scan = new Scanner(System.in);
        int menu = 0;

        System.out.println("Pilih program untuk dijalankan");
        System.out.println("1. Menambah set karyawan");
        System.out.println("2. Melihat set karywan");
        System.out.println("3. Mencari data karyawan");
        System.out.println("4. Tambahkan data default");
        System.out.println("5. Mengkonversi dari set ke list");
        System.out.println("6. Kembali ke menu utama");

        System.out.print("Pilih : ");

        menu = scan.nextInt();
        System.out.println(" ");

        if (menu!=0){
            switch (menu) {
                case 1:
                    TambahKaryawan(setKaryawan, scan, menu);
                    break;

                case 2:
                    lihatList(setKaryawan, menu);
                    break;

                case 3:
                    cariKaryawan(setKaryawan,menu, scan);
                    break;

                case 4:
                    DataDefault(setKaryawan);
                    System.out.println("Data berhasil ditambahkan!");
                    Beranda();
                    break;

                case 5:
                    listCollection.listKaryawan.addAll(setKaryawan);
                    System.out.println("Data berhasil ditambahkan!");
                    Beranda();
                    break;

                case 6:
                    Main.Beranda();
                    break;
            }
        }
    }

    public static void DataDefault(HashSet<listDataKaryawan> listdef) {
        listDataKaryawan dataKaryawan1 = new listDataKaryawan(425, "Muhammad Kholbi", "IT");
        listDataKaryawan dataKaryawan2 = new listDataKaryawan(456, "Rossa", "Marketing");
        listDataKaryawan dataKaryawan3 = new listDataKaryawan(136, "Fulki Mamduh", "Marketing");
        listDataKaryawan dataKaryawan4 = new listDataKaryawan(631, "Ahmad", "HR");
        listDataKaryawan dataKaryawan5 = new listDataKaryawan(628, "Muhammad Javier", "IT");
        listDataKaryawan dataKaryawan6 = new listDataKaryawan(912, "Michael Sunardi", "Management");
        listDataKaryawan dataKaryawan7 = new listDataKaryawan(395, "Wulan Mulawati", "Management");
        listDataKaryawan dataKaryawan8 = new listDataKaryawan(852, "Mahbub Amirudin", "IT");

        listdef.add(dataKaryawan1);
        listdef.add(dataKaryawan2);
        listdef.add(dataKaryawan3);
        listdef.add(dataKaryawan4);
        listdef.add(dataKaryawan5);
        listdef.add(dataKaryawan6);
        listdef.add(dataKaryawan7);
        listdef.add(dataKaryawan8);
    }

    public static void Restart(int menu, HashSet<listDataKaryawan> setKaryawan){
        Scanner scan2 = new Scanner(System.in);
        menu = 0;
        System.out.print("\n1. Keluar\n2. Kembali ke menu utama\nPilih : ");
        int temp = scan2.nextInt();
        System.out.print("\n");

        if (temp == 2){
            Beranda();
        }
    }

    public static void TambahKaryawan(HashSet<listDataKaryawan> AddSet, Scanner scan, int menu){
        int jumlahKaryawan = 0;

        System.out.println("\nBerikut adalah pengisian untuk data karyawan perusahaan 'A'\ndiharapkan untuk mengisi data karyawan dengan sesuai\n");
        System.out.print("Berapa banyak data yang ingin dimasukan? : ");
        jumlahKaryawan = scan.nextInt();
        System.out.println(" ");

        for (int i = 0; i < jumlahKaryawan; i++) {
            System.out.println("===============");
            System.out.print("Masukan id : ");
            int id = scan.nextInt();

            scan.nextLine();

            System.out.print("Masukan nama : ");
            String nama = scan.nextLine();

            System.out.print("Masukan departemen : ");
            String dept = scan.nextLine();

            AddSet.add(new listDataKaryawan(id, nama, dept));
        }

        System.out.println("Data berhasil ditambahkan!");
        Restart(menu, AddSet);
    }

    public static void lihatList(HashSet<listDataKaryawan> setKaryawan, int menu){
        for(listDataKaryawan dataKaryawan : setKaryawan){
            System.out.println(dataKaryawan+"\n");
        }

        Restart(menu, setKaryawan);
    }

    public static void cariKaryawan(HashSet<listDataKaryawan> setKaryawan, int menu, Scanner scan) {
        System.out.print("Pilih kategori dalam mencari\n1. ID\n2. Nama\n3. Departemen\n4. Keluar\nPilih : ");
        int kategori = scan.nextInt();
        if (kategori == 1) {
            int cariId = scan.nextInt();

            for (listDataKaryawan karyawan : setKaryawan) {
                System.out.print("Tulis ID karyawan : ");
                if (karyawan.getId() == cariId) {
                    System.out.println(karyawan.getNama());
                }
            }
            Restart(menu, setKaryawan);
        } else if (kategori == 2) {
            System.out.print("Tulis nama karyawan : ");
            scan.nextLine();
            String cariNama = scan.nextLine();

            for (listDataKaryawan karyawan : setKaryawan) {
                String[] liskar = karyawan.getNama().split(" ");
                String nama = liskar[0];

                if (nama.equals(cariNama)) {
                    System.out.println(karyawan.getNama());
                }
            }
            Restart(menu, setKaryawan);
        } else if (kategori == 3) {
            System.out.print("Tulis nama departemen : ");
            scan.nextLine();
            String cariDept = scan.nextLine();

            for (listDataKaryawan karyawan : setKaryawan) {
                if (karyawan.getDepartemen().equals(cariDept)) {
                    System.out.println(karyawan.getNama());
                }
            }
            Restart(menu, setKaryawan);
        } else {
            Restart(menu, setKaryawan);
        }
    }
}

class HashSetDataKaryawan {
    private int id;
    private String nama;
    private String departemen;

    public HashSetDataKaryawan(int id, String nama, String departemen) {
        this.id = id;
        this.nama = nama;
        this.departemen = departemen;
    }

    public String toString() {
        return "==================\nId : " + id + "\nNama : " + nama + "\nDepartemen : " + departemen;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getDepartemen() {
        return departemen;
    }
}