import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        String keep = "";
        if (n % 2 == 1) {
            keep = s.substring(n / 2, n / 2 + 1);
        }

        char[] chars = s.substring(0, n / 2).toCharArray();
        Arrays.sort(chars);
        String half = new String(chars);

        StringBuilder reversedHalf = new StringBuilder(half).reverse();

        return half + keep + reversedHalf.toString();
    }
}