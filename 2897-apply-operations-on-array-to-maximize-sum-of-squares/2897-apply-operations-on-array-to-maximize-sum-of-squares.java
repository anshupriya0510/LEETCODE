class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] count = new int[31];

        // Step 1: Count the set bits in every position
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }

        long ans = 0;

        // Step 2: Construct k maximum numbers
        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int j = 0; j < 31; j++) {
                if (count[j] > 0) {
                    num |= (1L << j);
                    count[j]--;
                }
            }

            // Step 3: Add the square
            ans = (ans + num * num) % MOD;
        }

        return (int) ans;
    }
}