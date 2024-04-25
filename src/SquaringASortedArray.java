public class SquaringASortedArray {

    public static void main(String[] args) {

        int[] nums = new int[] {-3, -1, 0, 1, 2};

        int [] result = makeSqaures(nums);

        for(int i: result){
            System.out.print(i + " ");
        }
    }

    public static int[] makeSqaures(int[] arr) {

        int []result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int highestSquareIndex = arr.length - 1;


        while(left <= right) {

            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if(leftSquare <= rightSquare) {
                result[highestSquareIndex--] = rightSquare;
                right--;
            } else {
                result[highestSquareIndex--] = leftSquare;
                left++;
            }

        }
        return result;
    }
}
