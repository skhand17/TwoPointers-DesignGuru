package practice.praticeAgain.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, -1, 1, -3};
        int target = 1;
        List<List<Integer>> result = searchQuadruplets(arr, target);
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        // TODO: Write your code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                countQuad(arr, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    public static void countQuad(int[] arr, int target, int i, int j, List<List<Integer>> quadruplets) {

        int left = j + 1;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[i] + arr[j] + arr[left] + arr[right] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[j]);
                list.add(arr[left]);
                list.add(arr[right]);
                quadruplets.add(list);
                left++;
                right--;

                while (left <= right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left <= right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (arr[i] + arr[j] + arr[left] + arr[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
