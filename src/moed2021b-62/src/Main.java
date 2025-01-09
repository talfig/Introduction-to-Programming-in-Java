public class Main {
    private static boolean equalSplit (int [] arr,
                                       int count1,
                                       int count2,
                                       int sum1,
                                       int sum2,
                                       int i) {
        if (i == arr.length)
            return count1 == count2 && sum1 == sum2;
        return equalSplit(arr, count1 + 1, count2, sum1 + arr[i], sum2, i + 1)
                || equalSplit(arr, count1, count2 + 1, sum1, sum2 + arr[i], i + 1);

    }
    public static boolean equalSplit (int [] arr) {
        if (arr.length % 2 != 0)
            return false;
        return equalSplit(arr, 0, 0, 0, 0, 0);
    }
    // Time - O(log n)
    // Space - O(1)
    public static boolean search (int [][] mat, int num) {
        int lowRow = 0 , highRow = mat.length - 1;
        int lowCol = 0, highCol = mat[0].length - 1;
        while (lowRow <= highRow || lowCol <= highCol) {
            int midRow = (lowRow + highRow)/2;
            int midCol = (lowCol + highCol)/2;
            if (mat[midRow][midCol] == num) {
                System.out.println("row = " + midRow);
                System.out.println("col = " + midCol);
                return true;
            }
            int firstLow = mat[lowRow][lowCol];
            int firstHigh = mat[midRow][lowCol];
            int secondLow = mat[lowRow][midCol + 1];
            int secondHigh = mat[midRow][midCol + 1];
            int thirdLow = mat[midRow + 1][midCol + 1];
            int thirdHigh = mat[highRow][midCol + 1];
            int fourthLow = mat[midRow + 1][lowCol];
            int fourthHigh = mat[highRow][lowCol];
            if (firstLow <= num && firstHigh >= num) {
                highRow = midRow;
                highCol = midCol;
            }
            else if (secondLow <= num && secondHigh >= num) {
                lowCol = midCol + 1;
                highRow = midRow;
            }
            else if (thirdLow <= num && thirdHigh >= num) {
                lowRow = midRow + 1;
                lowCol = midCol + 1;
            }
            else {
                lowRow = midRow + 1;
                highCol = midCol;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        int [] arr = {-3, 5, 12, 14, -9, 13};
        //System.out.println(equalSplit(arr));
        int [][] mat = {{1, 3, 7, 9},
                {6, 4, 15, 11},
                {36, 50, 21, 22},
                {60, 55, 30, 26}};
        System.out.println(search(mat, 22));
    }
}