public class Main {
    private static int friend3 (int[][] mat, int i, int j, int k, int counter) {
        if (k > mat.length - 1) {
            k = ++j + 1;
        }
        if (j > mat.length - 2) {
            j = ++i + 1;
            k = j + 1;
        }
        if (i > mat.length - 3)
            return counter;
        if (mat[i][j] + mat[i][k] + mat[j][k] == 3) {
            System.out.println(i + " " + j + " " + k);
            counter++;
        }
        return friend3 (mat, i, j, k + 1, counter);
    }
    public static int friend3 (int[][] mat) {
        return friend3(mat, 0, 1, 2, 0);
    }
    public static int findPeak (int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1])
                return arr[mid];
            low = (arr[mid + 1] >= arr[mid - 1]) ? mid + 1 : low;
            high = (arr[mid + 1] < arr[mid - 1]) ? mid - 1 : high;
        }
        return Math.max(arr[low], arr[high]);
    }
    public static void main(String[] args) {
        int[][] mat1 = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        int[][] mat2 = {
                {0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 1, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
        };
        int[] arr = {1, 2, 3, 4, 90, 0};
        System.out.println(friend3(mat1));
        //System.out.println(friend3(mat2));
        //System.out.println(findPeak(arr));
    }
}