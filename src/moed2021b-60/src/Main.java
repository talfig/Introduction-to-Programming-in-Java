public class Main {
    public static int smallestSub (int[] a, int k) {
        int i = 0, j = 1;
        int sum = a[0];
        int maxLength = a.length + 1;
        while (j < a.length) {
            if (sum + a[j] <= k) {
                sum += a[j];
                j++;
            }
            else {
                sum -= a[i];
                maxLength = j - i + 1;
                i++;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int[] a = {1, 4, 13, 6, 0, 19};
        System.out.println(smallestSub(a, 2));
    }
}