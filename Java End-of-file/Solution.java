import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int lineNo = 0; 
        while(scanner.hasNext()){
             lineNo++;
            System.out.println(lineNo + " " + scanner.nextLine());
         }
        scanner.close();
    }
}
