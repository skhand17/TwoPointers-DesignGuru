package practice.praticeAgain.Easy;

public class NextNonDuplicateNumberInstances {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        int ans = nextNonDuplicate(arr);
        System.out.println(ans);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static int nextNonDuplicate(int [] arr){

        int nextNonDuplicateIdx = 1;

        for(int i=1; i<arr.length; i++){
            if(arr[nextNonDuplicateIdx - 1] != arr[i]){
                arr[nextNonDuplicateIdx] = arr[i];
                nextNonDuplicateIdx++;
            }
        }
        return nextNonDuplicateIdx;
    }
}
