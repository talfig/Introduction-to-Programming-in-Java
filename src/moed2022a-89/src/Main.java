// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static int strStep (String st1, String st2, int step) {
        if (step == st1.length())
            return -1;
        if (isJump(st1, st2, step))
            return step;
        return strStep(st1, st2, step + 1);
    }
    public static int strStep (String st1, String st2) {
        return strStep(st1, st2, 1);
    }
    public static boolean isJump (String st1, String st2, int step) {
        if (st2.length() == 0)
            return true;
        if (st1.length() == 0)
            return false;
        if (st2.charAt(0) == st1.charAt(0))
            return isJump (st1.substring(step), st2.substring(1), step);
        return false;
    }
    public static int longestSubarray (int[] a) {
        int i = 0, j = 1, start = 0, end = 0;
        int maxLength = 1;
        while (j != a.length) {
            if (a[j] * a[j - 1] > 0) {
                i = j;
            }
            else if (maxLength < j - i + 1) {
                maxLength = j - i + 1;
                start = i;
                end = j;
            }
            j++;
        }
        System.out.println("Starting index = " + start + " Ending index = " + end);
        return maxLength;
    }
    public static void main(String[] args) {
        int [] a = {1, -2, 3, -4, -5, 4, 2, -4, 6, -2};
        System.out.println(longestSubarray(a));
    }
}