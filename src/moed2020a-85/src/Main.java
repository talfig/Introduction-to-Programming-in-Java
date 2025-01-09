public class Main {
    private static int findMaximum (int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == -1)
            return 0;
        if (i % 2 == 0)
            return mat[i][j] + Math.max(findMaximum(mat, i, j + 1), findMaximum(mat, i + 1, j));
        return mat[i][j] + Math.max(findMaximum(mat, i, j - 1), findMaximum(mat, i + 1, j));
    }
    public static int findMaximum (int[][] mat) {
        if (mat[0][0] == -1)
            return -1;
        return findMaximum (mat, 0, 0);
    }
    public static int strictlyIncreasing (int[] a) {
        if (a.length <= 1)
            return 0;
        int i = 0, j = 1;
        int count = 0;
        while (j < a.length) {
            if (a[j] > a[j - 1]) {
                count++;
                j++;
            }
            else
                j = ++i + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, -1, 1, 1},
                {1, 0, 0, -1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, 1, 1, 1},
                { 1, 1, -1, -1, 1}
        };
        int[] a = {1, 2, 4, 4, 5};
        System.out.println(findMaximum(mat));
        System.out.println(strictlyIncreasing(a));
    }
}