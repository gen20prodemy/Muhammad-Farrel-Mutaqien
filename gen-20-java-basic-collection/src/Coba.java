public class Coba {

    public static void main(String[] args) {
        int input = 123456789;
        String toString = String.valueOf(input);
        String[] bagian = toString.split("(?<=\\G.{1})");

        String temp = toString(bagian[1]+bagian[4]+bagian[9]+bagian[6]);
        int hasil =0;

        System.out.println(temp);
    }
}