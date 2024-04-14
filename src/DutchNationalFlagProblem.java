public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 0, 1, 2, 0};

        int[] result = sort(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public static int[] sort(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        for (int i = 0; i <= high; ) {

            /*
             *  if array element at index i is 0 then it means we need to swap the element at index i with element at index low
             * to bring 0 to the left side of the array
             * */
            if (arr[i] == 0) {
                swap(arr, i, low);
                low++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else { // this is the case where arr[i] == 2 it means that 2 should be moved to the right side of the array

                swap(arr, i, high);
                high--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
