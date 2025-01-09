public class Main {
    public static int longestPath (int[][] mat, int x, int y, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 0)
            return 0;
        if (i == x && j == y)
            return 1;
        mat[i][j] = 0;
        int left = 1 + longestPath(mat, x, y, i, j - 1);
        int right = 1 + longestPath(mat, x, y, i, j + 1);
        int up = 1 + longestPath(mat, x, y, i - 1, j);
        int down = 1 + longestPath(mat, x, y, i + 1, j);
        mat[i][j] = 1;
        return Math.max(left, Math.max(right, Math.max(up, down)));
    }
    public static int longestPath (int[][] mat, int x, int y) {
        return longestPath(mat, x, y, 0, 0);
    }
    // Time complexity is linear O(n + m)
    // Space complexity is fixed O(1)
    public static int howManyNegativeNumbers (int[][] mat) {
        int i = 0, j = mat[0].length - 1;
        int count = 0;
        while (j >= 0 && i < mat.length) {
            if (mat[i][j] < 0) {
                count += j + 1;
                i++;
            }
            else
                j--;
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1}
        };
        int[][] mat2 = {
                {-99, -72, -64, -55, -28, -10, -5},
                {-72, -53, -46, -38, 11, 13, 22},
                {-63, -48, -27, -12, 14, 16, 23},
                {-44, -29, -10, 0, 18, 20, 28},
                {0, 12, 14, 20, 28, 30, 35}
        };
        System.out.println(longestPath(mat1, 2, 5));
        System.out.println(howManyNegativeNumbers(mat2));
    }
}