class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.putIfAbsent(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);
        }
        for(int k=0;k<n;k++){
            if(mp.containsKey(nums[k]) && mp.get(nums[k]).size()>=3){
                List<Integer> list = mp.get(nums[k]);
                mp.remove(nums[k]);
                int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
                for(int i=0;i<=arr.length-3;i++)
                ans = Math.min(ans, (Math.abs(arr[i] - arr[i+1]) + Math.abs(arr[i+1] - arr[i+2]) + Math.abs(arr[i+2] - arr[i])));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}