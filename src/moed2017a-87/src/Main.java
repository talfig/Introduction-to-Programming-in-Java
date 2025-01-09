public class Main {
    private static boolean allZero (int[] x) {
        for (int i = 0; i < x.length; i++)
            if (x[i] != 0)
                return false;
        return true;
    }
    private static void copy (int[] dest, int[] src) {
        for (int i = 0; i < src.length; i++)
            dest[i] = src[i];
    }
    private static void xZero (int[] x, int[] y) {
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                if (x[i] == y[j])
                    x[i] = 0;
    }
    private static boolean covers (int[][] mat, int[] arr, int k, int row) {
        if (allZero(arr))
            return true;
        if (k == 0 || row == mat.length)
            return false;
        boolean skip = covers (mat, arr, k, row + 1);
        int[] temp = new int[arr.length];
        copy (temp, arr);
        xZero(temp, mat[row]);
        return covers (mat, temp, k - 1, row + 1) || skip;
    }
    public static boolean covers (int[][] mat, int[] arr, int k) {
        int[] x = new int[arr.length];
        copy (x, arr);
        return covers (mat, x, k, 0);
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 5, 1},
                {3, 1, 9},
                {7, 2, 3},
        };
        int[] arr = {7, 2, 3};
        System.out.println(covers(mat, arr, 2));
    }
}