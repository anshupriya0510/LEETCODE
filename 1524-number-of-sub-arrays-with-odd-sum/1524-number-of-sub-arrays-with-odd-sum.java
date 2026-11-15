class Solution {
    public int numOfSubarrays(int[] arr) {

        long even = 1;
        long odd = 0;

        long count = 0;
        long mod = 1000000007;

        int sum = 0;

        for(int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if(sum % 2 == 0) {

                count += odd;
                even++;

            } else {

                count += even;
                odd++;

            }
        }

        return (int)(count % mod);
    }
}