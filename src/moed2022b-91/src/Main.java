public class Main {
    private static int cheapRt (int[] stations, int step1, int step2, int limit, int i, int sum, String path) {
        if (i >= stations.length)
            return Integer.MAX_VALUE;
        sum += stations[i];
        path += i + "\t";
        if (i == stations.length - 1) {
            System.out.println(path + " = " + sum);
            return sum;
        }
        if (limit == 0)
            return cheapRt (stations, step1, step2, limit, i + step1, sum, path);
        return Math.min(cheapRt (stations, step1, step2, limit, i + step1, sum, path),
                cheapRt (stations, step1, step2, limit - 1, i + step2, sum, path));
    }
    public static int cheapRt (int[] stations, int step1, int step2, int limit) {
        return cheapRt (stations, step1, step2, limit, 0, 0, "");
    }
    private static int findMax (int[] arr, int i, int j) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int k = 0; k < arr.length; k++) {
            if (maxValue < arr[k] && k != i && k != j) {
                maxIndex = k;
                maxValue = arr[k];
            }

        }
        return maxIndex;
    }
    private static int findMin (int[] arr, int i) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int k = 0; k < arr.length; k++) {
            if (minValue > arr[k] && k != i) {
                minIndex = k;
                minValue = arr[k];
            }

        }
        return minIndex;
    }
    public static int findTriplet (int [] arr) {
        int max1 = findMax(arr, -1, -1);
        int max2 = findMax(arr, max1, -1);
        int max3 = findMax(arr, max1, max2);
        int min1 = findMin(arr, -1);
        int min2 = findMin(arr, min1);
        int mul1 = arr[max1] * arr[max2] * arr[max3];
        int mul2 = arr[min1] * arr[min2] * arr[max1];
        return Math.max(mul1, mul2);

    }
    public static void main(String[] args) {
        int[] stations = {2, 4, 8, 3, 10, 1, 12, 3, 2};
        System.out.println(cheapRt(stations, 3, 2, 4));
        int[] arr = {-4, 1, -8, 9, 6};
        System.out.println(findTriplet(arr));
    }
}