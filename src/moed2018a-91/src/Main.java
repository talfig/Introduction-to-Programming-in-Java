public class Main {
    private static int cheapestRoute (int[] stations, int i, int price) {
        if (i == stations.length - 2)
            return price + stations[i + 1];
        if (i == stations.length - 1)
            return price + stations[i];
        return Math.min(cheapestRoute(stations, i + 1, price + stations[i]),
                cheapestRoute(stations, i + 2, price + stations[i]));
    }
    public static int cheapestRoute (int[] stations) {
        return cheapestRoute (stations, 0, 0);
    }
    public static void sortMod (int [] a, int k)
    {
        int index = 0;
        for ( int i = 0; i <= k ; i ++ )
            for ( int j = 0; j < a.length; j++ )
            {
                if ( a[j] % k == i )
                {
                    int tmp = a[index];
                    a[index] = a[j];
                    a[j] = tmp;
                    index++ ;
                }
            }

    }
    public static void main(String[] args) {
        int[] stations = {2, 8, 3, 4, 7, 1, 3, 2};
        System.out.println(cheapestRoute(stations));
    }
}