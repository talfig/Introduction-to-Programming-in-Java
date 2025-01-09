public class Main {
    public static String substring (String str, int beginIndex) {
        if (beginIndex == str.length())
            return "";
        return str.charAt(beginIndex) + substring(str, beginIndex + 1);
    }
    public static int edit (String str1, String str2) {
        if (str1.length() == 0)
            return str2.length();
        if (str2.length() == 0)
            return str1.length();
        if (str1.charAt(0) == str2.charAt(0))
            return edit (substring(str1, 1), substring(str2, 1));
        int add = 1 + edit (str1, substring(str2, 1));
        int del = 1 + edit (substring(str1, 1), str2);
        return Math.min (add, del);
    }
    public static void main(String[] args) {
        String str1 = "geek", str2 = "gesek";
        System.out.println(edit(str1, str2));
        str1 = "sunday";
        str2 = "saturday";
        System.out.println(edit(str1, str2));
    }
}