class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] res = new char[n];

        // Step 1: fill with '?'
        for (int i = 0; i < n; i++) res[i] = '?';

        char ch = 'a';

        // Step 2: build lexicographically smallest string
        for (int i = 0; i < n; i++) {
            if (res[i] != '?') continue;

            if (ch > 'z') return "";

            for (int j = i; j < n; j++) {
                if (lcp[i][j] > 0) {
                    res[j] = ch;
                }
            }
            ch++;
        }

        // Step 3: compute LCP from built string
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else
                    dp[i][j] = 0;
            }
        }

        // Step 4: validate matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(res);
    }
}