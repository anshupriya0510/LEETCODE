class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int size = n * m;

        int[] arr = new int[size];
        int idx = 0;

        // flatten matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j] % MOD;
            }
        }

        int[] res = new int[size];

        // prefix product
        int prefix = 1;
        for (int i = 0; i < size; i++) {
            res[i] = prefix;
            prefix = (prefix * arr[i]) % MOD;
        }

        // suffix product
        int suffix = 1;
        for (int i = size - 1; i >= 0; i--) {
            res[i] = (res[i] * suffix) % MOD;
            suffix = (suffix * arr[i]) % MOD;
        }

        // reshape to matrix
        int[][] ans = new int[n][m];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = res[idx++];
            }
        }

        return ans;
    }
}