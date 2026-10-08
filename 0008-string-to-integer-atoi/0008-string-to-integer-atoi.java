class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        int sign = 1;
        if(i<n && s.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else if(i<n && s.charAt(i)=='+'){
            i++;
        }
        long result = 0;
        while(i<n && s.charAt(i)>='0'&&s.charAt(i)<='9'){
            int digit = s.charAt(i)-'0';
            result = result*10 + digit;
            if(result*sign>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(result*sign<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        
        return (int)(result*sign);
    }
}

        