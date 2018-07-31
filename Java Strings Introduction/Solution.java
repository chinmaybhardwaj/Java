import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int compare = A.compareTo(B);

        System.out.println(A.length() + B.length());

        if (compare < 0) {
            //a is smaller
            System.out.println("No");
        }
        else if (compare > 0) {
            //a is larger
            System.out.println("Yes");
        }
        else {
            //a is equal to b
            System.out.println("No");
        }
        System.out.println(A.substring(0,1).toUpperCase() + A.substring(1).toLowerCase()
                + " " + B.substring(0,1).toUpperCase() + B.substring(1).toLowerCase());
    }
}
