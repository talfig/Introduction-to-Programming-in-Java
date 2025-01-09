public class Main {
    public static int strictlyIncreasing(int[] arr) {
        int i, j, numOfArrays = 0;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = i; j < arr.length - 1 && arr[j] < arr[j + 1]; j++)
                numOfArrays += j - i + 1;
            i = j;
        }
        return numOfArrays;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 4, 5};
        int[] arr2 = {1, 3, 2};
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println(strictlyIncreasing(arr1));
        System.out.println(strictlyIncreasing(arr2));
        System.out.println(strictlyIncreasing(arr3));
    }
}