class Solution {
    public boolean checkValidString(String s) {
       int balance = 0;
       for(int i = 0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch=='('||ch=='*'){
            balance++;
        }
        else{
            balance--;
        }
        if(balance<0){
            return false;
        }
       }
         balance =0;
       for(int i=s.length()-1;i>=0;i--){
        char ch = s.charAt(i);
        if(ch==')'||ch=='*'){
            balance++;
        }
        else{
            balance--;
        }
        if(balance<0){
            return false;
        }
       }
       return true;
                

        
       
    }
}