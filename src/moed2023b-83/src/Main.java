public class Main {
    public static int findSmallestSubarrayLen (int[] arr, int num) {
        if (arr[0] > num) {
            System.out.println("Subarray found [" + 0 + "-" + (0) + "]");
            return 1;
        }
        int i = 0, j = 1;
        int sum = arr[0];
        int minLen = arr.length;
        int minStart = 0;
        while (j < arr.length)
        {
            if (sum + arr[j] > num) {
                System.out.println("Subarray found [" + i + "-" + j + "]");
                minStart = (minLen > j - i + 1) ? i : minStart;
                minLen = Math.min(minLen, j - i + 1);
                sum -= arr[i];
                i++;
            }
            else {
                sum += arr[j];
                j++;
            }

        }
        if (minLen == arr.length) {
            System.out.println("No subarray exists");
            return 0;
        }
        System.out.println("Smallest Subarray found [" + minStart + "-" + (minStart + minLen - 1) + "]");
        return minLen;
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 7, 3, 1, 4, 1, 8};
        System.out.println(findSmallestSubarrayLen(arr, 15));
    }
}