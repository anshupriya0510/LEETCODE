class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long right = (long)1e18;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReduce(long time, int height, int[] workers) {

        long total = 0;

        for (int w : workers) {

            long l = 0, r = (long)1e6;

            while (l <= r) {
                long mid = l + (r - l) / 2;

                long cost = w * mid * (mid + 1) / 2;

                if (cost <= time) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            total += r;

            if (total >= height) return true;
        }

        return total >= height;
    }
}