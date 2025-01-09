public class Main {
    private static boolean isPrime (int num, int div) {
        if (num % div == 0)
            return false;
        if (div >= Math.sqrt(num))
            return true;
        return isPrime (num, div + 1);
    }
    public static int nextPrime (int currentPrime) {
        currentPrime++;
        if (isPrime(currentPrime, 2))
            return currentPrime;
        return nextPrime (currentPrime);
    }
    private static int selectedPrimes (int num, int x, int count, int currentPrime) {
        if (num % currentPrime == 0)
            return selectedPrimes (num / currentPrime, x, count + 1, currentPrime);
        if (count == x) {
            System.out.println(currentPrime);
            return 1 + selectedPrimes(num, x, 0, nextPrime(currentPrime));
        }
        if (num == 1)
            return 0;
        return selectedPrimes (num, x, 0, nextPrime(currentPrime));
    }
    public static int selectedPrimes (int num, int x) {
        return selectedPrimes (num, x, 0, 2);
    }
    public static int findAlmostSorted (int[] arr, int num) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num)
                return mid;
            if (mid >= 1 && arr[mid - 1] == num)
                return mid - 1;
            if (mid < arr.length - 1 && arr[mid + 1] == num)
                return mid + 1;
            if (arr[mid] < num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(selectedPrimes(819819000, 2));
        int[] a = {10, 3, 40, 20, 50, 80, 70};
        System.out.println(findAlmostSorted(a, 40));
    }
}