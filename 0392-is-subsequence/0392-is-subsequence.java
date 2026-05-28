class Solution {
    public boolean isSubsequence(String s, String t) {
        int count = 0;
        String sb="";
        for(int i=0;i<t.length();i++){
            if(count<s.length() && s.charAt(count)==t.charAt(i)){
            sb+=t.charAt(i);
            count++;
            }
        }
        if(sb.equals(s)){
            return true;
        }
        return false;  
    }
}