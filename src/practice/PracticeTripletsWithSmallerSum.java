package practice;

import java.util.Arrays;

public class PracticeTripletsWithSmallerSum {

    public static void main(String[] args) {

        int[] nums = new int[] {-1, 4, 2, 1, 3};
        int target =5;

        int count =  searchTriplets(nums, target);
        System.out.println(count);
    }

    public static int searchTriplets(int[]nums, int target) {

        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length - 2; i++) {
            count +=countTriplets(nums, target - nums[i], i);

        }
        return count;
    }

    public static int countTriplets(int[] nums, int target, int i) {
        int right = nums.length - 1;
        int left = i + 1;
        int count  = 0;
        while(left < right) {

            if(nums[left] + nums[right] < target) {
                count += right - left;
                left++;
            } else
                right --;
        }

        return count;
    }
}
