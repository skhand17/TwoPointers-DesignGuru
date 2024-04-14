import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSumReturnTriplets {

    public static void main(String[] args) {

        int[] arr = new int[]{-1, 4, 2, 1, 3};
        int target = 5;

        List<List<Integer>> list = searchTriplets(arr, 5);
        for(List<Integer> innerList : list){
            System.out.println(innerList);
        }
    }

    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            searchForThem(i, list, target - arr[i], arr);
        }

        return list;
    }

    public static void searchForThem(int currentIndex, List<List<Integer>> list, int targetSum, int[] arr) {

        int left = currentIndex + 1;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                for (int i = right; i > left; i--) {
                    list.add(Arrays.asList(arr[currentIndex], arr[left], arr[i]));
                }
                left++;
            } else {
                right--;
            }
        }
    }
}
