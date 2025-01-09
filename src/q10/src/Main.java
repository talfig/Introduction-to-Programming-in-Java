import java.util.Arrays;

public class Main {
    private static void fillHadamard (int[][] mat, int i, int j, int n) {
        if (n == 1)
            return;
        mat[i + n/2][j] = mat[i][j];
        mat[i][j + n/2] = mat[i][j];
        mat[i + n/2][j + n/2] = -mat[i][j];
        fillHadamard(mat, 0, 0, n/2);
        fillHadamard(mat, i + n/2, j, n/2);
        fillHadamard(mat, i, j + n/2, n/2);
        fillHadamard(mat, i + n/2, j + n/2, n/2);
    }
    public static void fillHadamard (int[][] mat) {
        mat[0][0] = 1;
        fillHadamard(mat, 0, 0, mat.length);
    }
    public static void main(String[] args) {
        int[][] mat = new int[8][8];
        fillHadamard(mat);
        for (int i = 0; i < mat.length; i++)
            System.out.println(Arrays.toString(mat[i]));
    }
}