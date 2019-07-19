import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String[] subStringArray = new String[s.length() - k +1];
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i=0; i<= s.length(); i++){
            if(i+k <= s.length())
                subStringArray[i] =  s.substring(i,i+k);
        }

        smallest = subStringArray[0];
        largest = subStringArray[0];
        for(int i=0; i<subStringArray.length; i++){

            int compareSmallest = smallest.compareTo(subStringArray[i]);
            int compareLargest = largest.compareTo(subStringArray[i]);

            if (compareSmallest > 0) {
                //a is larger
                smallest = subStringArray[i];
            }

            if (compareLargest < 0) {
                //a is smaller
                largest = subStringArray[i];
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
