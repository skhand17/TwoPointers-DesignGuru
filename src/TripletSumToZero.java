import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public static void main(String[] args) {

        int[] arr = new int[]{-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> triplets = searchTriples(arr);

        for (List<Integer> li : triplets) {
            System.out.println(li);
        }

    }

    public static List<List<Integer>> searchTriples(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            searchPair(arr, i + 1, -arr[i], triplets);

        }

        return triplets;

    }

    public static void searchPair(int[] arr, int left,
                                  int targetSum, List<List<Integer>> triplets) {

        int right = arr.length - 1;

        while (left < right) {

            if (targetSum == arr[left] + arr[right]) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }

                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (targetSum > arr[left] + arr[right]) {
                left++;
            } else {
                right--;
            }
        }
    }
}
