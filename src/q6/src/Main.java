public class Main {
    public static boolean isPythagorean (int[] arr) {
        for (int k = 2; k < arr.length; k++) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] <= 0)
                    i++;
                else if (arr[i] * arr[i] + arr[j] * arr[j] == arr[k] * arr[k])
                    return true;
                if (arr[i] * arr[i] + arr[j] * arr[j] > arr[k] * arr[k])
                    j--;
                else
                    i++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6};
        System.out.println(isPythagorean(arr));
    }
}