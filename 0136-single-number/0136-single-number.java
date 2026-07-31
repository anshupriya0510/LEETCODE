class Solution {
    public int singleNumber(int[] nums) {
        int value =0;
        for(int j =0;j<nums.length;j++){
            value = value^nums[j];
        
        }
        return value;
        
    }
}