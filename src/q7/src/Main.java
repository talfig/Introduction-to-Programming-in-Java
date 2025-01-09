import java.util.Arrays;

public class Main {
    public static void markReg (boolean[][] mat, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat.length || !mat[i][j])
            return;
        mat[i][j] = false;
        markReg (mat, i - 1, j);
        markReg (mat, i + 1, j);
        markReg (mat, i, j - 1);
        markReg (mat, i, j + 1);
    }
    public static int cntTrueReg (boolean[][] mat, int i, int j, int countReg) {
        if (i == mat.length)
            return countReg;
        if (j == mat.length)
            return cntTrueReg (mat, i + 1, 0, countReg);
        if (mat[i][j]) {
            countReg++;
            markReg(mat, i, j);
        }
        return cntTrueReg(mat, i, j + 1, countReg);
    }
    public static int cntTrueReg (boolean[][] mat) {
        return cntTrueReg(mat, 0, 0, 0);
    }
    public static void main(String[] args) {
        boolean[][] mat = {
                {false, false, false, false, true},
                {false, true, true, true, false},
                {false, false, true, true, false},
                {true, false, false, false, false},
                {true, true, false, false, false}
        };
        System.out.println(cntTrueReg(mat));
    }
}