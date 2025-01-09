import java.util.Arrays;

public class Main {
    private static int maxPath (int[][] mat, int i, int j) {
        if (i >= mat.length || j >= mat[0].length)
            return Integer.MIN_VALUE;
        if (i == mat.length - 1 && j == mat[0].length - 1)
            return mat[i][j];
        int digit1 = mat[i][j] / 10;
        int digit2 = mat[i][j] % 10;
        int move1 = mat[i][j] + maxPath (mat, i + digit1, j + digit2);
        int move2 = mat[i][j] + maxPath (mat, i + digit2, j + digit1);
        return Math.max(move1, move2);
    }
    public static int maxPath (int[][] mat) {
        return maxPath(mat, 0, 0);
    }
    // Time Complexity - O(n)
    // Space Complexity - O(1)
    public static void sortMod (int[] a, int k) {
        int place = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] % k == i) {
                    int temp = a[place];
                    a[place] = a[j];
                    a[j] = temp;
                    place++;
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] a = {35, 17, 13, 252, 4, 128, 7, 3, 81};
        sortMod(a, 10);
        System.out.println(Arrays.toString(a));
        int[][] mat = {
                {12, 22, 23, 54, 11},
                {43, 35, 21, 20, 30},
                {34, 23, 43, 22, 30},
                {25, 31, 2, 20, 34},
                {10, 22, 10, 11, 10},
                {40, 13, 3, 1, 23}
        };
        System.out.println(maxPath(mat));
    }
}