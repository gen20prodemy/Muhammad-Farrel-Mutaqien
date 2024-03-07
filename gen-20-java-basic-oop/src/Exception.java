import java.util.Scanner;
public class Exception {
    public static int validasiInputInteger (Scanner scan){
        while(true){
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Input tidak valid!!");
                scan.nextLine();
            }
        }
    }
}
