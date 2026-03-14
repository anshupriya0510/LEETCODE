class Solution {
    List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {
        backtrack("", n);

        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    private void backtrack(String s, int n) {
        if (s.length() == n) {
            list.add(s);
            return;
        }

        for (char ch : new char[]{'a','b','c'}) {
            if (s.length() == 0 || s.charAt(s.length()-1) != ch) {
                backtrack(s + ch, n);
            }
        }
    }
}