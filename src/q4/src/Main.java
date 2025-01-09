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
    public static void main (String[] args) {
        int[] arr = {1, 3, 6, 2};
        System.out.println(printExpr(arr, 6));
    }
}