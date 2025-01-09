public class Main {
    private static int countPairs (int n, int leftPar, int rightPar, String exp) {
        if (leftPar < rightPar)
            return 0;
        if (n == 0) {
            if (leftPar > rightPar)
                return 0;
            System.out.println(exp);
            return 1;
        }
        return countPairs (n - 1, leftPar + 1, rightPar, exp + "(")
                + countPairs (n - 1, leftPar, rightPar + 1, exp + ")");

    }
    public static int countPairs (int n) {
        return countPairs (2 * n, 0, 0, "");
    }
    public static boolean superInc (int [] arr, int k) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == k)
                return true;
            if (arr[i] < k)
                k -= arr[i];
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 27};
        //System.out.println(superInc(arr, 30));
        System.out.println(countPairs(4));
    }
}