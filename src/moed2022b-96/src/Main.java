public class Main {

    private static int calc (int num, int result, int maxOp, int calc, String exp) {
        if (maxOp < 0)
            return 0;
        if (calc == result) {
            System.out.println(exp + " = " + result);
            return 1;
        }
        int sum = calc(num, result, maxOp - 1, calc + num, exp + " + " + num);
        int dif = calc(num, result, maxOp - 1, calc - num, exp + " - " + num);
        int mul = calc(num, result, maxOp - 1, calc * num, exp + " * " + num);
        int div = calc(num, result, maxOp - 1, calc / num, exp + " / " + num);
        return sum + dif + mul + div;
    }
    public static int calc (int num, int result, int maxOp) {
        return calc (num, result, maxOp, num, num + "");
    }
    private static int closestNot0 (int[] a, int low, int high, int i) {
        int j = i;
        while (a[i] == 0 && a[j] == 0 && j > low && i < high) {
            i++;
            j--;
        }
        if (a[i] > 0 || a[j] > 0)
            return (a[i] > 0) ? i : j;
        return -1;
    }
    public static int kAlmostSearch (int[] a, int num) {
        int low = 0, high = a.length - 1, mid;
        while (low <= high) {
            mid = closestNot0 (a, low, high, (low + high)/2);
            if (mid == -1)
                return -1;
            else if (a[mid] == num)
                return mid;
            else if (a[mid] > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {3, 0, 0, 4, 7, 9, 0, 0, 0, 0, 11, 15, 0, 19, 20, 0, 0, 31, 40, 0};
        int num = 31;
        System.out.println(kAlmostSearch(a, num));
    }
}