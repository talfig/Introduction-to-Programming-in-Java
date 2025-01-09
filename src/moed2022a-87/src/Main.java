public class Main {
    private static boolean isIdentity (int[][] mat, int x, int size, int i, int j) {
        if (i == x + size)
            return true;
        if (j == x + size)
            return isIdentity (mat, x, size, i + 1, x);
        if (i == j && mat[i][j] != 1)
            return false;
        if (i != j && mat[i][j] != 0)
            return false;
        return isIdentity (mat, x, size, i, j + 1);
    }
    public static boolean isIdentity (int[][] mat, int x, int size) {
        return isIdentity (mat, x, size, x, x);
    }
    private static int maxMatrix (int[][] mat, int x, int size) {
        if (x < 0)
            return size - 2;
        if (isIdentity(mat, x, size))
            return maxMatrix (mat, x - 1, size + 2);
        return Math.max(0, size - 2);
    }
    public static int maxMatrix (int[][] mat) {
        return maxMatrix (mat, mat.length / 2, 1);
    }
    private static int diff (int [] a) {
        int d1 = a[1] - a[0];
        int d2 = Integer.MAX_VALUE;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] != d1)
                d2 = a[i + 1] - a[i];
        }
        return Math.min(d1, d2);
    }
    public static int findMissingIndex (int [] a) {
        int d = diff (a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] != d)
                return i + 1;
        }
        return a.length;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 2, 0, 1, 2},
                {0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {5, 0, 0, 1, 0, 0, 0},
                {7, 0, 0, 0, 1, 0, 0},
                {8, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0}};
        System.out.println(isIdentity (mat, 2, 3));
        System.out.println(maxMatrix (mat));
        int [] a1 = {22, 24, 26, 32, 34, 36, 38, 40};
        int [] a2 = {22, 26, 28};
        int [] a3 = {2, 4, 6, 8, 10};
        System.out.println(findMissingIndex (a1));
        System.out.println(findMissingIndex (a2));
        System.out.println(findMissingIndex (a3));
    }
}