class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
         for(int i=0;i<nums.length;i++){
            int reqnum = target-nums[i];
            if(hm.containsKey(reqnum)){
                int[] arr={hm.get(reqnum),i};
                return arr;
            }
            hm.put(nums[i],i);
         }
    
    return null;
}
}
            