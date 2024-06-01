package practice.praticeAgain.Easy;

public class SquaringASortedArray {

    public static void main(String[] args) {

        int[] arr = new int[] {-2, -1, 0, 2, 3};
        int[] ans = sqaureSortedArray(arr);
        for(int i : ans){
            System.out.print(i + " ");
        }

    }

    private static int[] sqaureSortedArray(int[] arr) {

        int[] ans = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int highestSqaureIdx = arr.length - 1;

        while (left < right) {

            int leftSqaure = arr[left] * arr[left];
            int rightSqaure = arr[right] * arr[right];

            if(leftSqaure > rightSqaure){
                ans[highestSqaureIdx--] = leftSqaure;
                left++;
            } else {
                ans[highestSqaureIdx--] = rightSqaure;
                right--;
            }
        }
        return ans;
    }



}
