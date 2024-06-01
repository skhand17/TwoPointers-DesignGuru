package practice.praticeAgain.Easy;

public class PairWithTargetSum {

    public static void main(String[] args) {

        int[] arr = new int[] {1, 2, 3, 4, 6};
        int target = 6;
        int[] ans = targetSum(arr, target);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] targetSum(int[] arr, int target) {

        int i=0;
        int j = arr.length - 1;
        int currentSum = 0;
        while(i < j){
            currentSum = arr[i] + arr[j];
            if(currentSum == target){
                return new int[]{i, j};
            } else if (currentSum > target){
                j--;
            }else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
