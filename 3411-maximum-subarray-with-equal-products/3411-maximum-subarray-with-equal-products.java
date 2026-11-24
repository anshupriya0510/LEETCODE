class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
         
         for(int i=0;i<n;i++){
            int product =1;
            int gcd = nums[i];
            int lcm = nums[i];

            for(int j=i;j<n;j++){
                product *= nums[j];

                gcd = findGCD(gcd,nums[j]);
                lcm = findLCM(lcm,nums[j]);

                if(product== gcd*lcm){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
         }
         return maxLen;

    }
    public int findGCD(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a= temp;
        }
        return a;
    }
    public int findLCM(int a,int b){
        return (a/findGCD(a,b))*b;
    }
         
        
    
}