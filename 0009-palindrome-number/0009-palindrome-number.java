class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false ;
        }
        int revsum= 0;
        int original = x;
        while(x!=0){
             int last = x%10;
             revsum = revsum * 10 + last;
             x = x/10;
        }
             if (original==revsum){
            return  true;
             }
             else {
               return  false;
             }
        
        
    }
}