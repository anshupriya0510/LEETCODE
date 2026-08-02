class Solution {
    public int[] rearrangeArray(int[] nums) {
        int result[]=new int [nums.length];
        int positive = 0;
        int negative = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result[positive]=nums[i];
                positive = positive +2;
            }
            else{
                result[negative]=nums[i];
                negative=negative+2;
            }
        }
        return result;
        
    }
}