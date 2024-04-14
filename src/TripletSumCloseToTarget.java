import java.util.Arrays;

public class TripletSumCloseToTarget {

    public static void main(String[] args) {

        int [] arr = new int[] {-1, 0, 2, 3};
        int target = 3;
//        /*
//        Return ans as 2 because the triplet -1,0,3 has a sum as 2 which is closest to the target
//        */
        Arrays.sort(arr);
        int smallestSum = searchTriplet(arr, target);
        System.out.println(smallestSum);
    }

    public static int searchTriplet(int[] arr, int target) {
        int smallestDifference = Integer.MAX_VALUE;

        if(arr.length < 3)
            throw new IllegalArgumentException();

        for(int i=0; i<arr.length - 2; i++){

            int left = i + 1;
            int right = arr.length - 1;

            while(left < right) {
                int targetDiff =  target - arr[i] - arr[left] -arr[right];

                if(targetDiff == 0){
                    return target;
                }

                if(Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || Math.abs(targetDiff) == Math.abs(smallestDifference)
                && targetDiff > smallestDifference){
                    smallestDifference = targetDiff;
                }
                if(targetDiff > 0)
                    left++;
                else
                    right--;
            }

        }
        return target - smallestDifference;
    }
}
