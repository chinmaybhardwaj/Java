import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String array[] = s.split("[^A-Za-z]+");
        System.out.println(array.length);
        if (array.length > 0 && array[0].isEmpty()) {
            array = Arrays.copyOfRange(array, 1, array.length);
        }
        for(int i=0; i< array.length; i++){
            System.out.println(array[i]);
        }
        scan.close();
    }
}
