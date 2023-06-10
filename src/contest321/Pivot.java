package contest321;

/**
Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.

Input: n = 1
Output: 1
Explanation: 1 is the pivot integer since: 1 = 1.

Input: n = 4
Output: -1
Explanation: It can be proved that no such integer exist.

1 <= n <= 1000

 **/
public class Pivot {

    public int pivotInteger(int n) {
        int pivot = n / 2;
        while (pivot <= n) {
            if (calcSum(1, pivot - 1) == calcSum(pivot + 1, n)) {
                return pivot;
            }
            pivot++;
        }
        return -1;
    }

    public int calcSum(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }


    public static void main(String[] args) {
        var pivot = new Pivot();
        System.out.println(pivot.pivotInteger(8));
        System.out.println(pivot.pivotInteger(4));
        System.out.println(pivot.pivotInteger(1));
        System.out.println(pivot.pivotInteger(2));
        System.out.println(pivot.pivotInteger(10));
        System.out.println(pivot.pivotInteger(20));
    }

}
