class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int largest = nums[0];
        int smallest = nums[n-1];
        while(smallest!=0){
            int rem = largest%smallest;
            largest = smallest;
            smallest = rem;
        }
        return largest;
    }
}