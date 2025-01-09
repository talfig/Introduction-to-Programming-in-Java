public class Main {
    private static boolean sumPower3 (int num, int pow) {
        if (num == 0 || num - Math.pow(3, pow) < 0)
            return num == 0;
        return sumPower3 (num, pow + 1)
                || sumPower3 ((int) (num - Math.pow(3, pow)), pow + 1);
    }
    public static boolean sumPower3 (int num) {
        return sumPower3 (num, 0);
    }
    public static void main(String[] args) {
        int a = 3;
        System.out.println(sumPower3 (37));
    }
}