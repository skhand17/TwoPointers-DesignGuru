import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubArraysWithProductLessThanTarget {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 10};
        int target = 30;

        List<List<Integer>> result = findSubArrays(arr, target);
        for(List<Integer> list : result){
            System.out.print(list + " ");
        }
    }

    public static List<List<Integer>> findSubArrays(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int left = 0;

        double product = 1;

        for (int right = 0; right < arr.length; right++) {

            product *= arr[right];


            while (product >= target) {
                product /= arr[left];
                left++;
            }

            List<Integer> temp = new LinkedList<>();

            for (int i = right; i >= left; i--) {
                temp.add(0, arr[i]);

                result.add(new ArrayList<>(temp));
            }


        }

        return result;
    }
}
