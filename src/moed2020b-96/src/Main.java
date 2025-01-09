public class Main {
    private static int max (int a1,
                            int a2,
                            int a3,
                            int a4,
                            int a5,
                            int a6,
                            int a7,
                            int a8) {
        if (a1 == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return Math.max(a1, max(a2, a3, a4, a5, a6, a7, a8, Integer.MIN_VALUE));
    }
    private static int maxSumKnight (int[][] mat, int sum, int i, int j, int prev) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || Math.abs(mat[i][j] - prev) > 1)
            return -1;
        if (i == mat.length - 1 && j == mat[0].length - 1)
            return sum + mat[i][j];
        int temp = mat[i][j];
        mat[i][j] = -1;
        int one = maxSumKnight (mat, sum + temp, i - 1, j - 2, temp);
        int two = maxSumKnight (mat, sum + temp, i - 2, j - 1, temp);
        int three = maxSumKnight (mat, sum + temp,i - 2, j + 1, temp);
        int four = maxSumKnight (mat, sum + temp,i - 1, j + 2, temp);
        int five = maxSumKnight (mat, sum + temp,i + 1, j + 2, temp);
        int six = maxSumKnight (mat, sum + temp,i + 2, j + 1, temp);
        int seven = maxSumKnight (mat, sum + temp,i + 2, j - 1, temp);
        int eight = maxSumKnight (mat, sum + temp,i + 1, j - 2, temp);
        mat[i][j] = temp;
        return max (one, two, three, four, five, six, seven, eight);
    }
    public static int maxSumKnight (int[][] mat) {
        return maxSumKnight(mat, 0, 0, 0, mat[0][0]);
    }
    public static int minimalPositive (Range[] rangeA) {
        int low = 0, high = rangeA.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (rangeA[mid].get_big() > 0 && rangeA[mid].get_small() <= 0)
                return 1;
            if (rangeA[mid].get_small() <= 0)
                low = mid + 1;
            else
                high = mid;
        }
        return (rangeA[high].get_small() > 0) ? rangeA[high].get_small() : -1;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {4, 5, 6, 7, 1},
                {3, 5, 1, 7, 4},
                {4, 5, 6, 5, 8},
                {3, 4, 7, 7, 9},
                {6, 2, 2, 7, 6}
        };
        Range[] rangeA = {
                new Range(-1, -1),
                new Range(2, 2),
                new Range(5, 6),
                new Range(20, 22)
        };
        System.out.println(maxSumKnight(mat));
        System.out.println(minimalPositive(rangeA));
    }
}