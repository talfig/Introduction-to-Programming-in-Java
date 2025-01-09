public class Main {
    public static void printArr (int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
                if (j == arr[0].length - 1)
                    System.out.println();
            }
    }
    private static boolean findWord (char[][] arr, String word, int i, int j, int k, int[][] mat, boolean isFound) {
        if (word.length() == k || isFound)
            return true;
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length || arr[i][j] == '0')
            return false;
        if (word.charAt(k) == arr[i][j])
            mat[i][j] = ++k;
        else if (k >= 1)
           return false;
        char temp = arr[i][j];
        arr[i][j] = '0';
        boolean left = findWord(arr, word, i, j - 1, k, mat, isFound);
        boolean right = findWord(arr, word, i, j + 1, k, mat, left);
        boolean up = findWord(arr, word, i - 1, j, k, mat, right);
        boolean down = findWord(arr, word, i + 1, j, k, mat, up);
        arr[i][j] = temp;
        if (!down)
            mat[i][j] = 0;
        return down;
    }
    public static void findWord (char[][] arr, String word) {
        int[][] mat = new int[arr.length][arr.length];
        if (findWord (arr, word, 0, 0, 0, mat, false))
            printArr(mat);
        else
            System.out.println("No Such Word");
    }
    public static boolean isHighFactorInRange (int n, int low, int high) {
        for (int i = n / 2; i >= 0; i--)
            if (n % i == 0)
                return (low <= i && i <= high);
        return false;
    }
    public static void findFactors (int n) {
        int low = 2, high = n / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (n % mid == 0) {
                System.out.println(mid + "\t" + n / mid);
                break;
            }
            else if (isHighFactorInRange(n, mid, high))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return;
    }
    public static void main(String[] args) {
        char[][] arr = {
                {'t', 'z', 'x', 's', 'h'},
                {'s', 'h', 'a', 'b', 'a'},
                {'h', 'w', 'l', 'o', 'm'},
                {'o', 'r', 'n', 't', 'o'},
                {'a', 'b', 'r', 'i', 'm'}
        };
        findWord(arr, "abr");
        findFactors(8509);
    }
}