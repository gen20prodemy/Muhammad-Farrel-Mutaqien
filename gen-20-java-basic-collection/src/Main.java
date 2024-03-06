import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Beranda();
    }

    public static void Beranda(){
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
                    listCollection.Beranda();
                    break;

                case 2:
                    HashSetCollection.Beranda();
                    break;

                default:
                    Beranda();
            }
        }
    }
}