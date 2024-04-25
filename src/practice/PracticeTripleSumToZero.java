package practice;

import javax.naming.ldap.PagedResultsResponseControl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeTripleSumToZero {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-3, 0, 1, 2, -1, 1, -2));
        int[] nums = new int[]{-3, 0, 1, 2, -1, 1, -2};

        List<List<Integer>> result = tripletSumToZero(nums);

        for(List<Integer> innerList : result){
            System.out.println(innerList);
        }
    }

    public static List<List<Integer>> tripletSumToZero(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if(i >0 && nums[i] == nums[i-1])
                continue;
            checkForIt(nums, -nums[i], i, i + 1, result);
        }

        return result;

    }

    public static List<List<Integer>> checkForIt(int[] nums, int targetSum,
                                                 int i, int left, List<List<Integer>> result) {
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == targetSum) {
                List<Integer> list = new ArrayList<>();
                list.add(-targetSum);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);

                left++;
                right--;

                while (left <= right && nums[left] == nums[left - 1])
                    left++;

                while (left <= right && nums[right] == nums[right + 1])
                    right--;
            } else if (nums[left] + nums[right] > targetSum)
                right--;
            else
                left++;
        }
        return result;
    }


}
