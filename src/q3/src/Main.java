public class Main {
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
        int[] a = {19, 19, 16, 15, 15, 15, 15, 13, 5};
        int[] b = {0, 12, 13, 14, 14, 15, 15, 19, 25, 30, 35};
        System.out.println(meetingPoint(a, b));
    }
}