public class PairWithTargetSum {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 5, 9, 11};
        int target = 11;

        int[] result = search(nums, target);

        for(int num : result){
            System.out.print(num + " ");
        }
    }

    public static int[] search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {


            if(nums[left] + nums[right] == target){
                return new int[]{left, right};
            } else if (nums[left] + nums[right] > target){
                right--;
            } else {
                left++;
            }

        }
        return new int[]{-1, -1};
    }
}
