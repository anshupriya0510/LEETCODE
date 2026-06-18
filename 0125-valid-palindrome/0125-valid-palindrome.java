class Solution {
    public boolean isPalindrome(String s) {
        String b = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = b.length()-1;
        while(i<j){
            if(b.charAt(i)!=b.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;


        
    }
}