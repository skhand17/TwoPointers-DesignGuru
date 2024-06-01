package practice.praticeAgain.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubArraysWithProductLessThanTarget {

    public static void main(String[] args) {

        int[] arr = new int[] {8, 2, 6, 5};
        int target = 50;
        List<List<Integer>> result = productLessThanTarget(arr, target);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> productLessThanTarget(int[] arr, int target) {

        List<List<Integer>> result = new ArrayList<>();

        double product  = 1;
        int left = 0;

        for(int right = 0; right < arr.length; right ++){
            product *= arr[right];

            while (product >= target){
                product /= arr[left++];
            }

            List<Integer> list = new LinkedList<>();

            for(int i=right; i>=left; i--){
                list.add(arr[i]);

                result.add(new ArrayList<>(list));
            }

        }
        return result;
    }
}
