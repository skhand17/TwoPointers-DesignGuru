import java.util.Arrays;

public class TripletsWithSmallerSum {

    public static void main(String[] args) {
        int [] arr = new int[]{-1, 4, 2, 1, 3};
        int target = 5;

        int count = searchTriplets(arr, target);
        System.out.println(count);

    }

    public static int searchTriplets(int[]arr, int target) {
        int count =0;
        Arrays.sort(arr);
        for(int i=0; i< arr.length - 2; i++) {
            count += searchPairs(arr, target - arr[i], i);
        }
        return count;
    }

    public static int searchPairs(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1;
        int right = arr.length - 1;

        while(left < right) {

            if(arr[left] + arr[right] < targetSum) {
                count += right - left;
                left++;
            } else {
                right --;
            }
        }
        return count;
    }
}
