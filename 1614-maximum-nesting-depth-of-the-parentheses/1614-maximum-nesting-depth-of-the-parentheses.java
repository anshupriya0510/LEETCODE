class Solution {
    public int maxDepth(String s) {
       int count = 0;
        int maxm = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count +=1;
            }
            if(s.charAt(i)==')'){
                if(count>maxm){
                    maxm=Math.max(maxm,count);
                   // maxm=count;
                }
                    count -= 1 ;
                
            }

        }
        return maxm;
        
    }
}