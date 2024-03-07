import java.util.Scanner;

public class Coba {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu =0;

        menu = Exception.validasiInputInteger(scan);

        if(menu != 0){
            next();
        }
    }

    public static void next(){
        System.out.println("angka masuk");
    }
}