package contest334;

import java.util.Arrays;

public class LeftRightDifference {

    public int[] leftRightDifference(int[] nums) {
        int[] values = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }
            values[i] = Math.abs(right - left);
        }
        return values;
    }

    public static void main(String[] args) {
        var values = new int[] {10,4,8,3};
        var difference = new LeftRightDifference();
        System.out.println(Arrays.toString(difference.leftRightDifference(values)));
        System.out.println(Arrays.toString(difference.leftRightDifference(new int[]{0})));
    }

}
