import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int menu = 0;

        System.out.println("Pilih jenis Exception");
        System.out.println("1. Number Format Exception");
        System.out.println("2. Null Pointer Exception");
        System.out.println("3. Arithmetic Exception");
        System.out.println("4. Array Index Out Of Bounds");
        System.out.println("5. File Not Found");
        System.out.println("6. Finally");
        System.out.print("Pilih Jenis : ");
        menu = scan.nextInt();
        System.out.println(" ");

        if(menu != 0) {
                ExceptionOp.InputData(menu);
        }
    }
}