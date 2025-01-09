public class Main {
    private static int printExpr (int[] arr, int num, int i, int sum, String exp) {
        if (i == arr.length) {
            if (sum != num)
                return 0;
            System.out.println(exp);
            return 1;
        }
        if (sum == num) {
            System.out.println(exp);
            return 1;
        }
        return printExpr (arr, num, i + 1, sum + arr[i], exp + "+" + arr[i] + " ")
                + printExpr (arr, num, i + 1, sum - arr[i], exp + "-" + arr[i] + " ")
                + printExpr (arr, num, i + 1, sum, exp);
    }
    public static int printExpr (int[] arr, int num) {
        return printExpr (arr, num, 0, 0, "");
    }
    private static int next0 (int[] a, int i) {
        for (int j = i + 1; j < a.length; j++)
            if (a[j] == 0)
                return j;
        return -1;
    }
    public static int longestSequence (int[] a, int k) {
        if (a.length == 1 && k == 0)
            return a[0] == 0 ? 0 : 1;
        int i = 0, j = 1;
        int maxLength = 0, count0 = (a[0] == 0) ? 1 : 0;
        while (j < a.length) {
            if (a[j] == 0)
                count0++;
            if (count0 > k) {
                maxLength = Math.max(maxLength, j - i); // j is equal to 0
                i = next0(a, i) + 1;
                j = i + 1;
                count0 = (a[i] == 0) ? 1 : 0;
            }
            j++;
        }
        return Math.max(maxLength, j - i); // j is equal to a.length
    }
    public static void main (String[] args) {
        int[] arr = {1, 3, 6, 2};
        int[] a = {1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};;
        //System.out.println(printExpr(arr, 6));
        System.out.println(longestSequence(a, 1));
    }
}