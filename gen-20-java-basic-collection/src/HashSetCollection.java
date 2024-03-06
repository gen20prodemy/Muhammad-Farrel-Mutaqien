import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class HashSetCollection {
        public static HashSet<ListDataKaryawan> setKaryawan = new HashSet<>();

    public static void beranda(){
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
                    TambahKaryawan(setKaryawan, scan);
                    break;

                case 2:
                    lihatList(setKaryawan);
                    break;

                case 3:
                    cariKaryawan(setKaryawan, scan);
                    break;

                case 4:
                    dataDefault(setKaryawan);
                    System.out.println("Data berhasil ditambahkan!");
                    beranda();
                    break;

                case 5:
                    ListCollection.listKaryawan.addAll(setKaryawan);
                    System.out.println("Data berhasil ditambahkan!");
                    beranda();
                    break;

                case 6:
                    Main.beranda();
                    break;
            }
        }
    }

    public static void dataDefault(HashSet<ListDataKaryawan> listdef) {
        ListDataKaryawan dataKaryawan1 = new ListDataKaryawan(425, "Muhammad Kholbi", "IT");
        ListDataKaryawan dataKaryawan2 = new ListDataKaryawan(456, "Rossa", "Marketing");
        ListDataKaryawan dataKaryawan3 = new ListDataKaryawan(136, "Fulki Mamduh", "Marketing");
        ListDataKaryawan dataKaryawan4 = new ListDataKaryawan(631, "Ahmad", "HR");
        ListDataKaryawan dataKaryawan5 = new ListDataKaryawan(628, "Muhammad Javier", "IT");
        ListDataKaryawan dataKaryawan6 = new ListDataKaryawan(912, "Michael Sunardi", "Management");
        ListDataKaryawan dataKaryawan7 = new ListDataKaryawan(395, "Wulan Mulawati", "Management");
        ListDataKaryawan dataKaryawan8 = new ListDataKaryawan(852, "Mahbub Amirudin", "IT");

        listdef.add(dataKaryawan1);
        listdef.add(dataKaryawan2);
        listdef.add(dataKaryawan3);
        listdef.add(dataKaryawan4);
        listdef.add(dataKaryawan5);
        listdef.add(dataKaryawan6);
        listdef.add(dataKaryawan7);
        listdef.add(dataKaryawan8);
    }

    public static void restart(){
        Scanner scan2 = new Scanner(System.in);
        int menu = 0;
        System.out.print("\n1. Keluar\n2. Kembali ke menu utama\nPilih : ");
        int temp = scan2.nextInt();
        System.out.print("\n");

        if (temp == 2){
            beranda();
        }
    }

    public static void TambahKaryawan(HashSet<ListDataKaryawan> AddSet, Scanner scan){
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

            AddSet.add(new ListDataKaryawan(id, nama, dept));
        }

        System.out.println("Data berhasil ditambahkan!");
        restart();
    }

    public static void lihatList(HashSet<ListDataKaryawan> setKaryawan){
        for(ListDataKaryawan dataKaryawan : setKaryawan){
            System.out.println(dataKaryawan+"\n");
        }

        restart();
    }

    public static void cariKaryawan(HashSet<ListDataKaryawan> setKaryawan, Scanner scan) {
        System.out.print("Pilih kategori dalam mencari\n1. ID\n2. Nama\n3. Departemen\n4. Keluar\nPilih : ");
        int kategori = scan.nextInt();
        if (kategori == 1) {
            int cariId = scan.nextInt();

            for (ListDataKaryawan karyawan : setKaryawan) {
                System.out.print("Tulis ID karyawan : ");
                if (karyawan.getId() == cariId) {
                    System.out.println(karyawan.getNama());
                }
            }
            restart();
        } else if (kategori == 2) {
            System.out.print("Tulis nama karyawan : ");
            scan.nextLine();
            String cariNama = scan.nextLine();

            for (ListDataKaryawan karyawan : setKaryawan) {
                String[] liskar = karyawan.getNama().split(" ");
                String nama = liskar[0];

                if (nama.equals(cariNama)) {
                    System.out.println(karyawan.getNama());
                }
            }
            restart();
        } else if (kategori == 3) {
            System.out.print("Tulis nama departemen : ");
            scan.nextLine();
            String cariDept = scan.nextLine();

            for (ListDataKaryawan karyawan : setKaryawan) {
                if (karyawan.getDepartemen().equals(cariDept)) {
                    System.out.println(karyawan.getNama());
                }
            }
            restart();
        } else {
            restart();
        }
    }
}