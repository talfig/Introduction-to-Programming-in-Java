public class Main {
    private static int longestSlope (int[][] mat, int num, int i, int j, int count, int prev) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == Integer.MAX_VALUE)
            return count;
        if (prev != mat[i][j] + num)
            count = 0;
        int temp = mat[i][j];
        mat[i][j] = Integer.MAX_VALUE;
        int left = longestSlope (mat, num, i, j - 1, count + 1, temp);
        int right = longestSlope (mat, num, i, j + 1, count + 1, temp);
        int up = longestSlope (mat, num, i - 1, j, count + 1, temp);
        int down = longestSlope (mat, num, i + 1, j, count + 1, temp);
        mat[i][j] = temp;
        return Math.max(Math.max(Math.max (left, right), up), down);
    }
    public static int longestSlope (int[][] mat, int num) {
        return longestSlope (mat, num, 0, 0, 0, mat[0][0] + num);
    }
    private static int sum (int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }
    public static int what (int[] a) {
        int i = 0, j = a.length - 1;
        int maxLength = a.length, sum = sum(a);
        while (i <= j) {
            if (sum % 2 == 1)
                return maxLength;
            if (a[i] % 2 == 1)
                return maxLength - 1;
            sum -= a[j];
            maxLength--;
            j--;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {3, 13, 15, 28, 30},
                {55, 54, 53, 27, 26},
                {54, 12, 52, 51, 50},
                {50, 10, 8, 53, 11}
        };
        int[] a = {1, 3, 1, 1, 1};
        System.out.println(longestSlope(mat, 1));
        System.out.println(what(a));
    }

}