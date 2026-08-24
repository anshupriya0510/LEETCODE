class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        long[] prefixsum = new long[n];
        prefixsum[0] = stones[0];
        for(int i=1;i<n;i++){
            prefixsum[i]=prefixsum[i-1]+stones[i];
        }
        long[] t= new long[n];
        t[n-1]=prefixsum[n-1];
        for(int i=n-2;i>=1;i--){
        long take = prefixsum[i]-t[i+1];
        long skip = t[i+1];
        t[i]=Math.max(take,skip);
        }
        return (int) t[1];
        
    }
}