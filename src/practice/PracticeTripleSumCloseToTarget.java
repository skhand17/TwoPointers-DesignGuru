package practice;

import java.util.Arrays;

public class PracticeTripleSumCloseToTarget {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 1, 1, 2, 6};
        int targetSum = 5;

        int currentTripleSum = searchTriplet(nums, targetSum);
        System.out.println(currentTripleSum);
    }

    public static int searchTriplet(int[] arr, int targetSum) {

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1;
            int right = arr.length - 1;


            while (left < right) {

                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];

                if (targetDiff == 0)
                    return targetSum;

                if (Math.abs(targetDiff) < Math.abs(smallestDifference) ||
                        Math.abs(targetDiff) == Math.abs(smallestDifference)
                                && targetDiff > smallestDifference) {

                    smallestDifference = targetDiff;

                } else if (targetDiff > 0)
                    left++;
                else
                    right--;
            }
        }

        return targetSum - smallestDifference;
    }
}
