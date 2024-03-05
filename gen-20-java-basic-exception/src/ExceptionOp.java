import java.util.Scanner;
import java.lang.NumberFormatException;
import java.lang.NullPointerException;
import java.lang.ArithmeticException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.FileNotFoundException;
import java.io.File;

public class ExceptionOp {
    public static void InputData(int menu){
        Scanner scan = new Scanner(System.in);
        String Input = " ";
        int Input1 = 0;
        int Input2 = 0;

        switch (menu){
            case 1:
                System.out.println("================================================");
                System.out.print("Tulis sesuatu disini :");
                Input = scan.nextLine();
                System.out.println(" ");

                NumberFormat(Input);

                Restart(menu, scan);
                break;

            case 2:
                System.out.println("================================================");
                System.out.println("Disini `Input` yang akan diberikan adalah null");
                System.out.println("jadi seperti ini\nString Input = null;\n");
                Input = null;

                NullPointer(Input);

                Restart(menu, scan);
                break;
            case 3:
                System.out.println("================================================");
                System.out.print("Tulis angka yang akan dibagi : ");
                Input1 = scan.nextInt();
                System.out.print("Tulis angka yang akan membagi : ");
                Input2 = scan.nextInt();
                System.out.println(" ");

                Arithmetic(Input1, Input2);

                Restart(menu, scan);

            case 4:
                int[] Arr = {1, 2, 3, 4, 5};
                System.out.println("================================================");
                System.out.println("Berikut Array yang dapat di tampilkan : ");
                System.out.println("Array : {1, 2, 3, 4, 5}");
                System.out.print("Tulis index yang ingin di munculkan : ");
                Input1 = scan.nextInt();
                System.out.println(" ");

                ArrayIndexOutOfBounds(Arr, Input1);

                Restart(menu, scan);

            case 5:
                System.out.println("================================================");
                System.out.print("Tulis nama file : ");
                Input = scan.nextLine();
                System.out.println(" ");

                FileNotFound(Input);

                Restart(menu, scan);

            case 6:
                System.out.println("================================================");
                System.out.print("Berikut tuliskan angka positif : ");
                Input1 = scan.nextInt();
                System.out.println(" ");

                CustomEx(Input1);

                Restart(menu, scan);

            case 7:
                System.out.println("================================================");
                System.out.println(" ");

                Finally(menu, scan);
        }


    }

    public static void Restart(int menu, Scanner scan){
        System.out.print("1.Iya\n2.Tidak\nUlang? : ");
        int temp = menu;
        menu = scan.nextInt();
        System.out.println(" ");
        if(menu == 1) {
            menu = temp;
            InputData(menu);
        } else {
            System.out.print("1.Iya\n2.Tidak\nKembali ke Menu? : ");
            menu = scan.nextInt();
            System.out.println(" ");
            if(menu == 1) {
                Main.main(new String[0]);
            }
        }
    }

    public static void NumberFormat(String Input){
        try {
            int ExInt = Integer.parseInt(Input);
            System.out.println(ExInt+" Adalah angka\n");
        } catch (NumberFormatException e){
            System.out.println("Bukan angka! \n"+e.getMessage());
        }
        System.out.println("================================================\n");
    }

    public static void NullPointer(String Input){
        try{
            int String = Input.length();
            System.out.println("Panjang input adalah : "+String);
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        System.out.println("================================================\n");
    }

    public static void Arithmetic(int Input1, int Input2){
        try{
            int result = Input1/Input2;
            System.out.println("Hasil pembagian : "+result);
        } catch (ArithmeticException e){
            System.out.println("Pembagian error! "+e.getMessage());
        }
        System.out.println("================================================\n");
    }

    public static void ArrayIndexOutOfBounds(int[] arr, int Input1){
        try{
            System.out.println("Angka dalam array adalah "+arr[Input1]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index tidak valid! "+e.getMessage());
        }
        System.out.println("================================================\n");
    }

    public static void FileNotFound(String Input){
        try {
            File file = new File(Input+".txt");
            Scanner scaning = new Scanner(file);
            System.out.println("File "+file+" ditemukan");
        } catch (FileNotFoundException e){
            System.out.println("File tidak dapat ditemukan! "+e.getMessage());
        }
        System.out.println("================================================\n");
    }


    public static void Finally(int menu, Scanner scan){
        try{
            System.exit(0);
//            Restart(menu, scan);
        } finally {
            System.out.println("Contoh finally!");
        }
        System.out.println("================================================\n");
    }

    public static void CustomEx(int Input1){
        try {
            if (Input1 < 0) {
                throw new CustomException("Input tidak boleh negatif");
            } else {
                System.out.println("Input adalah bilangan bulat");
            }
        }catch (CustomException e){
            System.out.println("Input salah");
        }
        System.out.println("================================================\n");
    }
}
class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}
