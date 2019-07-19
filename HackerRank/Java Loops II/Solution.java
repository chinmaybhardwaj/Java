import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int query = a;
            String total = "";
           
            for(int q = 0; q < n; q++){
                double square = Math.pow(2, q);
                 query += square * b;
               
                if(q == 0)
                    total += query;
                else
                 total += " " + query;
            }
            System.out.println(total);
            query = 0;
            total = "";
        }
        in.close();
    }
}
