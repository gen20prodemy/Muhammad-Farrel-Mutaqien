import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        beranda();
    }

    public static void beranda(){
        Scanner scan = new Scanner(System.in);
        int menu = 0;

        System.out.println("Pilih data collection");
        System.out.println("1. List karyawan");
        System.out.println("2. Hash Set karywan");
        System.out.print("Pilih menu : ");

        menu = scan.nextInt();
        System.out.println(" ");

        if (menu!=0){
            switch (menu) {
                case 1:
                    ListCollection.beranda();
                    break;

                case 2:
                    HashSetCollection.beranda();
                    break;

                default:
                    beranda();
            }
        }
    }
}