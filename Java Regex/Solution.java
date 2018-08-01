import java.util.*;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0) {
            String pattern = in.nextLine();
            //Write your code
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Exception  exception) {
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
}
