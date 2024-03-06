import java.util.ArrayList;
import java.util.List;

public class Coba {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);

        List<Integer> listB = new ArrayList<>();
        listB.add(4);
        listB.add(5);

        // Memasukkan listA ke dalam listB
        listB.addAll(listA);

        System.out.println("List B setelah dimasukkan list A: " + listB);
    }
}