import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() != b.length())
            return false;

        long sumA = 0;
        long sumB = 0;
        Character[] arrayA = new Character[a.length()];
        Character[] arrayB = new Character[b.length()];

        for (int i = 0; i < a.length(); i++) {
            sumA += a.charAt(i);
            arrayA[i] = a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            sumB += b.charAt(i);
            arrayB[i] = b.charAt(i);
        }

        bubbleSort(arrayA);
        bubbleSort(arrayB);

        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] != arrayB[i])
                return false;
        }

        return sumA == sumB;
    }


    static void bubbleSort(Character[] array) {
        boolean swapped = true;
        int j = 0;
        char tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
