class Solution {
    public int missingMultiple(int[] nums, int k) {

        int i = 1;

        while (true) {

            int multiple = k * i;
            boolean found = false;

            for (int j = 0; j < nums.length; j++) {

                if (nums[j] == multiple) {
                    found = true;
                    break;
                }
            }

            if (found == false) {
                return multiple;
            }

            i++;
        }
    }
}