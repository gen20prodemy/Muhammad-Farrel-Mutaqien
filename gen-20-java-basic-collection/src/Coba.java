//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        List<DataKaryawan> listKaryawan = new ArrayList<>();
//
//        DataDefault(listKaryawan);
//        Beranda(listKaryawan);
//    }
//
//    public static void DataDefault(List<DataKaryawan> listdef) {
//        DataKaryawan dataKaryawan1 = new DataKaryawan(425, "Muhammad Kholbi", "IT");
//        DataKaryawan dataKaryawan2 = new DataKaryawan(456, "Rossa", "Marketing");
//        DataKaryawan dataKaryawan3 = new DataKaryawan(136, "Fulki Mamduh", "Marketing");
//        DataKaryawan dataKaryawan4 = new DataKaryawan(631, "Ahmad", "HR");
//        DataKaryawan dataKaryawan5 = new DataKaryawan(628, "Muhammad Javier", "IT");
//        DataKaryawan dataKaryawan6 = new DataKaryawan(912, "Michael Sunardi", "Management");
//        DataKaryawan dataKaryawan7 = new DataKaryawan(395, "Wulan Mulawati", "Management");
//        DataKaryawan dataKaryawan8 = new DataKaryawan(852, "Mahbub Amirudin", "IT");
//
//        listdef.add(dataKaryawan1);
//        listdef.add(dataKaryawan2);
//        listdef.add(dataKaryawan3);
//        listdef.add(dataKaryawan4);
//        listdef.add(dataKaryawan5);
//        listdef.add(dataKaryawan6);
//        listdef.add(dataKaryawan7);
//        listdef.add(dataKaryawan8);
//    }
//
//    public static void Beranda(List<DataKaryawan> listKaryawan) {
//        Scanner scan = new Scanner(System.in);
//        int menu = 0;
//
//        System.out.println("Pilih menu yang ingin dimasuki");
//        System.out.println("1. Menambah list karyawan");
//        System.out.println("2. Melihat list karywan");
//        System.out.println("3. Mencari data karyawan");
//        System.out.print("Pilih menu : ");
//
//        menu = scan.nextInt();
//        System.out.println(" ");
//
//        if (menu != 0) {
//            switch (menu) {
//                case 1:
//                    TambahKaryawan(listKaryawan, scan, menu);
//                    break;
//
//                case 2:
//                    lihatList(listKaryawan, menu);
//                    break;
//            }
//        }
//    }
//
//    public static void Restart(int menu, List<DataKaryawan> listKaryawan) {
//        Scanner scan2 = new Scanner(System.in);
//        menu = 0;
//        System.out.print("\n1. Keluar\n2. Kembali ke menu utama\nPilih : ");
//        int temp = scan2.nextInt();
//        System.out.print("\n");
//
//        if (temp == 2) {
//            Beranda(listKaryawan);
//        }
//    }
//
//    public static void TambahKaryawan(List<DataKaryawan> Addlist, Scanner scan, int menu) {
//        int jumlahKaryawan = 0;
//
//        System.out.println("\nBerikut adalah pengisian untuk data karyawan perusahaan 'A'\ndiharapkan untuk mengisi data karyawan dengan sesuai\n");
//        System.out.print("Berapa banyak data yang ingin dimasukkan? : ");
//        jumlahKaryawan = scan.nextInt();
//        System.out.println(" ");
//
//        for (int i = 0; i < jumlahKaryawan; i++) {
//            System.out.println("===============");
//            System.out.print("Masukan id : ");
//            int id = scan.nextInt();
//
//            scan.nextLine();
//
//            System.out.print("Masukan nama : ");
//            String nama = scan.nextLine();
//
//            System.out.print("Masukan departemen : ");
//            String dept = scan.nextLine();
//
//            Addlist.add(new DataKaryawan(id, nama, dept));
//        }
//
//        Restart(menu, Addlist);
//    }
//
//    public static void lihatList(List<DataKaryawan> listKaryawan, int menu) {
//        for (DataKaryawan dataKaryawan : listKaryawan) {
//            System.out.println(dataKaryawan + "\n");
//        }
//
//        Restart(menu, listKaryawan);
//    }
//
//    public static void cariKaryawan(List<DataKaryawan> listKaryawan, int menu, Scanner scan) {
//        System.out.println("Pilih kategori dalam mencari\n1. ID\n2. Nama\n3. Departemen\n4. Keluar");
//        int kategori = scan.nextInt();
//        if (kategori == 1) {
//            int cariId = scan.nextInt();
//
//            for (DataKaryawan karyawan : listKaryawan) {
//                if (karyawan.getId() == cariId) {
//                    System.out.println(karyawan.getNama());
//                }
//            }
//        } else if (kategori == 2) {
//            String cariNama = scan.nextLine();
//
//            for (DataKaryawan karyawan : listKaryawan) {
//                String[] liskar = karyawan.getNama().split(" ");
//                String nama = liskar[0];
//
//                if (nama.equals(cariNama)) {
//                    System.out.println(karyawan.getNama());
//                }
//            }
//        } else if (kategori == 3) {
//            String cariDept = scan.nextLine();
//
//            for (DataKaryawan karyawan : listKaryawan) {
//                if (karyawan.getDepartemen().equals(cariDept)) {
//                    System.out.println(karyawan.getNama());
//                }
//            }
//        }
//    }
//}
//
//class DataKaryawan {
//    private int id;
//    private String nama;
//    private String departemen;
//
//    public DataKaryawan(int id, String nama, String departemen) {
//        this.id = id;
//        this.nama = nama;
//        this.departemen = departemen;
//    }
//
//    public String toString() {
//        return "==================\nId : " + id + "\nNama : " + nama + "\nDepartemen : " + departemen;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public String getDepartemen() {
//        return departemen;
//    }
//}