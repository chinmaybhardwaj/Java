import java.util.*;

public class Solution {
    // Write your code here
    static boolean flag;
    static int B;
    static int H;

    static{
        // whatever code is needed for initialization goes here
        flag = true;
        Scanner  scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
        scanner.close();

        if(B <= 0 || H <= 0){
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class
