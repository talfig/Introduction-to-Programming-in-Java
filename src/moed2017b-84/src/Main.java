public class Main {
    public static int ways (int k, int n) {
        if (k == 0 && n == 0)
            return 1;
        if (k == 0)
            return 0;
        return ways (k - 1, n + 1)
                + ways (k - 1, n - 1);
    }
    public static boolean findSum (int[] a, int sum) {
        int i = 0, j = 1;
        while (a[i] < a[j % a.length])
            j = ++i + 1;
        j %= a.length;
        while (i != j) {
            if (a[i] + a[j] == sum)
                return true;
            if (a[i] + a[j] < sum)
                j = ++j % a.length;
            else
                i = (--i < 0) ? a.length - 1 : i;
        }
        return false;
    }
    public static void main (String[] args){
        System.out.println(ways(4, 2));
        int[] a = {3, 48, 49, 52, 65, 70, -5};
        System.out.println(findSum(a, 44));
    }
}