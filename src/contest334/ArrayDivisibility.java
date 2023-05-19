package contest334;

import java.util.Arrays;

public class ArrayDivisibility {

    public int[] divisibilityArray(String word, int m) {
        var length = word.length();
        int[] newArray = new int[length];
        long value = 0;
        System.out.println("Word: " + word);
        for (int i = 0; i < word.length(); i++) {
            long digit = word.charAt(i) - '0';
            System.out.println("Digit: " + digit);
            value = (value * 10 + digit);
            System.out.println("Value: " + value);
            var remainder = value % m;
            System.out.println("Remainder: " + remainder);
            newArray[i] = (remainder == 0) ? 1 : 0;
        }
        return newArray;
    }

    public static void main(String[] args) {
        var divisibility = new ArrayDivisibility();
        System.out.println(Arrays.toString(divisibility.divisibilityArray("998244353", 3)));
        System.out.println(Arrays.toString(divisibility.divisibilityArray("101010", 10)));
    }

}

