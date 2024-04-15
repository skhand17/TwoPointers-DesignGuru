import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, -1, 1, -2, 2};
        int target = 2;

        List<List<Integer>> quadruplets = iterate(arr, target);

        for (List<Integer> innerlist : quadruplets) {
            System.out.println(innerlist);
        }
    }

    public static List<List<Integer>> iterate(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();
        /*
         * First step is to sort an array using in-place sorting
         *
         * */
        Arrays.sort(arr);

        /*
         * Iterate over an outer loop till length of the array - 3
         *
         * */
        for (int i = 0; i < arr.length - 3; i++) {

            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                searchQuadruplets(arr, i, j, target, result);
            }

        }
        return result;

    }

    public static void searchQuadruplets(int[] arr, int first, int second, int target, List<List<Integer>> result) {

        int left = second + 1;
        int right = arr.length - 1;

        while (left < right) {

            int currentSum = arr[first] + arr[second] + arr[left] + arr[right];

            /*
             * This is the logic to compute if sum of 4 numbers is equal to the target
             *
             * */
            if (currentSum == target) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(arr[first]);
                tempList.add(arr[second]);
                tempList.add(arr[left]);
                tempList.add(arr[right]);

                result.add(tempList);
                left++;
                right--;

                while (left < right && arr[left] == arr[left - 1])
                    left++;

                while (left < right && arr[right] == arr[right + 1])
                    right--;

            } else if (currentSum < target)
                left++;
            else
                right--;
        }
    }
}
