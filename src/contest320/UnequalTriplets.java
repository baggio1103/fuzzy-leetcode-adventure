package contest320;

import java.util.List;

public class UnequalTriplets {

    public static void main(String[] args) {
        var test = new UnequalTriplets();
        int[] nums = {4, 4, 2, 4, 3, 5};
        System.out.println(test.unequalTriplets(nums));
    }

    public int unequalTriplets(int[] nums) {
        var counter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] != nums[j] && nums[k] != nums[i]) {
                            counter++;
                            System.out.println("i = " + i + " :  " + nums[i] + " - " + nums[j] +" - " + nums[k]);
                        }
                    }
                }
            }
        }
        return counter;
    }

}
