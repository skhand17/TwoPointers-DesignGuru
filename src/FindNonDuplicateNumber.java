public class FindNonDuplicateNumber {

    public static void main(String[] args) {

        int[] nums = new int[] {2, 2, 2, 11};

        int result = uniqueElement(nums);
        System.out.println(result);

    }

    public static int uniqueElement(int[] nums) {

        int count = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length) {

            if(nums[left] != nums[right]){
                count++;
            }
            left = right;
            right = right + 1;
        }
        return count + 1;
    }
}
