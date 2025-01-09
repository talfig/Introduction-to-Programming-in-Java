public class Main {
    public static int prince (int[][] drm, int i, int j, int prev, int min) {
        if (i < 0 || i >= drm.length || j < 0 || j >= drm.length || drm[i][j] == -2)
            return Integer.MAX_VALUE;
        if (drm[i][j] == -1)
            return min + 1;
        if (prev - 2 > drm[i][j] || prev + 1 < drm[i][j])
            return Integer.MAX_VALUE;
        int temp = drm[i][j];
        drm[i][j] = -2;
        int west = prince (drm, i, j - 1, temp, min + 1);
        int east = prince (drm, i, j + 1, temp, min + 1);
        int north = prince (drm, i - 1, j, temp, min + 1);
        int south = prince (drm, i + 1, j, temp, min + 1);
        drm[i][j] = temp;
        return Math.min(west, Math.min(east, Math.min(north, south)));
    }
    public static int prince (int[][] drm, int i, int j) {
        return prince (drm, i, j, drm[i][j], 0);
    }
    public static int findSingle (int[] a) {
         int low = 0, high = a.length - 1;
         while (low < high - 1) {
             int mid = (high + low) / 2;
             if (a[mid] != a[mid - 1] && a[mid] != a[mid + 1])
                 return a[mid];
             if (a[mid] == a[mid - 1])
                 mid--;
             if ((high - mid + 1) % 2 != 0)
                 low = mid + 1;
             else
                 high = mid - 1;
         }
         return a[high];
    }
    public static void main(String[] args) {
        int[][] drm = {
                {2, 0, 1, 2, 3},
                {2, 3, 5, 5, 4},
                {8, -1, 6, 8, 7},
                {3, 4, 7, 2, 4},
                {2, 4, 3, 1, 2}
        };
        System.out.println(prince(drm, 0, 0));
        int[] a = {1, 8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5};
        System.out.println(findSingle(a));
    }
}