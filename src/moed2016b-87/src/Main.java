public class Main {
    private static int count (int sum, int num) {
        if (sum == 0)
            return 1;
        if (sum < 0 || num > sum)
            return 0;
        return count(sum - (++num), num)
                + count(sum, num);
    }

    public static int count (int sum) {
        return count(sum, 0);
    }
    public static int subStrMaxC (String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                count++;
        return Math.max(count - 2, 0);
    }
    public static int subStrMaxC (String s, char c, int k) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                count++;
        for (int i = 0; i <= k; i++)
            sum += Math.max(count - i - 1, 0);
        return sum;
    }
    public static void main(String[] args) {
        String s = "abcbcabcacab";
        System.out.println(count(7));
        System.out.println(subStrMaxC(s, 'c', 2));

    }
}