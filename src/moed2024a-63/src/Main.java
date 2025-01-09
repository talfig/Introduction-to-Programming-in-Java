public class Main {
    private static int minPoint (int[][] m, int i, int j, int currentNum, int num) {
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
        if (currentNum + m[i][j] <= 0)
            return minPoint (m, i, j, currentNum + 1, num + 1);
        if (i + j == 0)
            return num;
        return Math.min (minPoint (m, i - 1, j, currentNum + m[i][j], num),
                minPoint (m, i, j - 1, currentNum + m[i][j], num));
    }
    public static int minPoint (int[][] m) {
        return minPoint (m, m.length - 1, m[0].length - 1, 1, 1);
    }
    public static int get (int[] b, int k) {
        if (k == 0)
            return b[0];
        return b[k] - b[k - 1];
    }
    public static int find (int[] b, int x) {
        int low = 0, high = b.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (get(b, mid) == x)
                return mid;
            if (get(b, mid) < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] m = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        int[] a = {-2, -1, 3, 5, 8};
        int[] b = {-2, -3, 0, 5, 13};
        System.out.println(minPoint(m));
        System.out.println(find(b, 8));
    }
}