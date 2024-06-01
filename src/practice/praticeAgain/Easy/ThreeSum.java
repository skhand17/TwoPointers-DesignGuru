package practice.praticeAgain.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = new int[]{-3, 0, 1, 2, -1, 1, -2};
        Arrays.sort(arr);
        List<List<Integer>> result = threeSum(arr);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<arr.length - 2; i++) {
            if( i > 0 && arr[i] == arr[i-1])
                continue;
            checkForThreeSum(-arr[i], i, i+1, arr, result);
        }
        return result;
    }

    public static void checkForThreeSum(int targetSum, int i, int left,
                                            int[] arr, List<List<Integer>> resultant) {

        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum){
                List<Integer> temp = new ArrayList<>();
                temp.add(-targetSum);
                temp.add(arr[left]);
                temp.add(arr[right]);
                resultant.add(temp);
                left++;
                right--;
                while (left <= right && arr[left] == arr[left - 1]){
                    left++;
                }
                while (left <= right && arr[right] == arr[right + 1]){
                    right--;
                }
            } else if(currentSum > targetSum){
                right--;
            } else {
                left++;
            }
        }
    }
}
