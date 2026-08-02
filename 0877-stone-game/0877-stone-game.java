class Solution {

    public int f(int left, int right, int[] piles, int[][] dp) {

        // No piles remaining
        if (left > right) {
            return 0;
        }

        // Already computed
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        // Alice picks the left pile
        int takeLeft = piles[left];

        // Bob picks left
        int lBobTakeLeft = f(left + 2, right, piles, dp);

        // Bob picks right
        int lBobTakeRight = f(left + 1, right - 1, piles, dp);

        // Bob minimizes Alice's future score
        takeLeft += Math.min(lBobTakeLeft, lBobTakeRight);

        // Alice picks the right pile
        int takeRight = piles[right];

        // Bob picks left
        int rBobTakeLeft = f(left + 1, right - 1, piles, dp);

        // Bob picks right
        int rBobTakeRight = f(left, right - 2, piles, dp);

        // Bob minimizes Alice's future score
        takeRight += Math.min(rBobTakeLeft, rBobTakeRight);

        // Alice chooses the better option
        return dp[left][right] = Math.max(takeLeft, takeRight);
    }

    public boolean stoneGame(int[] piles) {

        int n = piles.length;
        int totalStones = 0;

        for (int stone : piles) {
            totalStones += stone;
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int aliceScore = f(0, n - 1, piles, dp);

        return aliceScore > totalStones / 2;
    }
}