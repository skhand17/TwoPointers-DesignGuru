package practice.praticeAgain.Medium;

import java.util.Arrays;

public class TripletsWithSmallerSum {

    public static void main(String[] args) {

        int[] arr = new int[]{-1, 4, 2, 1, 3};
        int target = 5;
        int count = countTriplets(arr, target);
        System.out.println(count);
    }

    public static int countTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            count += resultCount(arr, target - arr[i], i);
        }
        return count;
    }

    private static int resultCount(int[] arr, int target, int i) {

        int count = 0;
        int left = i + 1;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] < target) {
                count += right - left;
                left++;
            } else
                right--;
        }
        return count;
    }
}
