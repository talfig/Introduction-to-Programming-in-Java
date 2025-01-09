public class Main {
    private static int oneFiveSeven (int n, int min) {
        if (n == 0)
            return min;
        if (n < 0)
            return Integer.MAX_VALUE;
        int one = oneFiveSeven (n - 1, min + 1);
        int five = oneFiveSeven (n - 5, min + 1);
        int seven = oneFiveSeven (n - 7, min + 1);
        return Math.min (one, Math.min (five, seven));
    }
    public static int oneFiveSeven (int n) {
        return oneFiveSeven(n, 0);
    }
    public static void printClosest (int[] a, int[] b, int x) {
        int i = 0, j = 0;
        while ((i < a.length - 1 || j < b.length - 1) && a[i] + b[j] <= x) {
            if (i == a.length - 1)
                j++;
            else if (j == b.length - 1)
                i++;
            else if (a[i + 1] < b[j + 1])
                i++;
            else
                j++;
        }
        if (i > 0 && Math.abs(x - a[i - 1] - b[j]) < Math.abs(x - a[i] - b[j]))
            i--;
        if (j > 0 && Math.abs(x - a[i] - b[j - 1]) < Math.abs(x - a[i] - b[j]))
            j--;
        System.out.println(a[i] + " and " + b[j]);
    }
    public static void main(String[] args) {
        int[] a = {0, 4, 6, 11, 11};
        int[] b = {10, 20, 30, 40};
        System.out.println(oneFiveSeven(6));
        printClosest(a, b, 13);
    }
}