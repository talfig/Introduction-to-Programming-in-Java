public class Main {
    public static int greatestRoute (int[][] mat, int[][] counter, int i, int j, int sum, String route) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || counter[i][j] == mat[i][j])
            return 0;
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            System.out.println(route + "(" + i + ", " + j + ")" + " = " + (sum + 1));
            return sum + 1;
        }
        int temp = counter[i][j]++;
        int left = greatestRoute (mat, counter, i, j - 1, sum + mat[i][j], route + "(" + i + ", " + j + ") --> ");
        int right = greatestRoute (mat, counter, i, j + 1, sum + mat[i][j], route + "(" + i + ", " + j + ") --> ");
        int up = greatestRoute (mat, counter, i - 1, j, sum + mat[i][j], route + "(" + i + ", " + j + ") --> ");
        int down = greatestRoute (mat, counter, i + 1, j, sum + mat[i][j], route + "(" + i + ", " + j + ") --> ");
        counter[i][j] = temp;
        return Math.max(Math.max(Math.max(left, right), up), down);
    }

    public static int greatestRoute (int[][] mat) {
        int[][] counter = new int[mat.length][mat[0].length];
        return greatestRoute (mat, counter, 0, 0, 0, "");
    }
    public static void findSubarray (int[] arr, int target) {
        int i = 0, j = 1;
        int sum = arr[0];
        while (j < arr.length) {
            if (sum == target) {
                System.out.println("Subarray found between indexes " + i + " and " + (j - 1) + " with sum " + sum);
                break;
            }
            else if (sum < target) {
                sum += arr[j];
                j++;
            }
            else {
                sum -= arr[i];
                i++;
            }
        }
        if (sum != target)
            System.out.println("No subarray was found with sum " + target);
    }
    public static void main(String[] args) {
        int[][] mat = {
                {2, 3},
                {4, 1}
        };
        //System.out.println(greatestRoute(mat));
        int[] arr = {2, 6, 0, 1, 9, 7, 3, 1, 4, 1, 8};
        findSubarray (arr, 16);
    }
}