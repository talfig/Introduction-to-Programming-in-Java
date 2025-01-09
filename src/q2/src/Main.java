public class Main {
    private static int longestSlope (int[][] mat, int num, int i, int j, int prev) {
        if (i < 0 || i > mat.length - 1 || j < 0 || j > mat[0].length - 1 || prev != mat[i][j] + num)
            return 0;
        int temp = mat[i][j];
        mat[i][j] = -1;
        int left = 1 + longestSlope (mat, num, i, j - 1, temp);
        int right = 1 + longestSlope (mat, num, i, j + 1, temp);
        int up = 1 + longestSlope (mat, num, i - 1, j, temp);
        int down = 1 + longestSlope (mat, num, i + 1, j, temp);
        mat[i][j] = temp;
        return Math.max(Math.max(Math.max (left, right), up), down);
    }
    public static int longestSlope1 (int[][] mat, int num, int i, int j) {
        if (j == mat[0].length) {
            j = 0;
            i++;
        }
        if (i == mat.length)
            return Integer.MIN_VALUE;
        int max = longestSlope (mat, num, i, j, mat[i][j] + num);
        return Math.max(max, longestSlope1 (mat, num, i, j + 1));

    }
    public static int longestSlope (int[][] mat, int num) {
        return longestSlope1 (mat, num, 0, 0);
    }
    public static void main(String[] args) {
        int[][] mat = {
                {3, 13, 15, 28, 30}, // mat[0][0] = 3
                {55, 54, 53, 27, 26},
                {54, 12, 52, 51, 50},
                {50, 10, 8, 53, 11}
        };
        System.out.println(longestSlope(mat, 1));
    }
}