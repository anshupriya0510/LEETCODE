class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for (int i=0;i<nums.length;i++){
            int maxl= Integer.MIN_VALUE;
            int minl = Integer.MAX_VALUE;
            for(int j=0;j<=i;j++){
                 maxl = Math.max(maxl,nums[j]);
            }
                for(int j=i;j<nums.length;j++){
                 minl = Math.min(minl,nums[j]);
            }
             int sub = maxl-minl;
             if(sub<=k){
                return i;
             }

        }
        return -1;
        
    }
}