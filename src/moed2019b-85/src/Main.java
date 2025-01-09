public class Main {
    private static int howManyPaths (int[][] mat, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0)
            return 0;
        if (i == mat.length - 1 && j == mat[0].length - 1)
            return 1;
        int temp = mat[i][j];
        mat[i][j] = 0;
        int left = howManyPaths (mat, i, j - temp);
        int right = howManyPaths (mat, i, j + temp);
        int up = howManyPaths (mat, i - temp, j);
        int down = howManyPaths (mat, i + temp, j);
        mat[i][j] = temp;
        return left + right + up + down;
    }
    public static int howManyPaths (int[][] mat) {
        return howManyPaths (mat, 0, 0);
    }
    public static int meetingPoint (int[] a, int[] b) {
        int low = 0, high = Math.min(a.length - 1, b.length - 1);
        while (low < high) {
            int mid = (low + high)/2;
            if (a[mid] == b[mid])
                high = mid;
            else if (a[mid] < b[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (a[high] == b[high])
            return high;
        return -1;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 1, 6},
                {2, 8, 1, 2},
                {6, 2, 7, 5},
                {2, 4, 1, 3}
        };
        int[] a = {19, 19, 16, 15, 15, 15, 15, 13, 5};
        int[] b = {0, 12, 13, 14, 14, 15, 15, 19, 25, 30, 35};
        System.out.println(howManyPaths(mat));
        System.out.println(meetingPoint(a, b));
    }
}