class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (target == nums[mid]) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies in the left sorted half
                if (target < nums[mid] && nums[left] <= target) {
                    right = mid - 1;
                } 
                else {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Target lies in the right sorted half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } 
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}