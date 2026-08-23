class Solution { 
    public boolean sumGame(String num) { 
        int n = num.length(); 
        int leftsum = 0; 
        int rightsum = 0; 
        int leftquestion = 0; 
        int rightquestion = 0; 
        
        for(int i = 0; i < n; i++){ 
            // FIXED: Changed num[i] to num.charAt(i)
            if(num.charAt(i) == '?'){ 
                if(i < n/2){ 
                    leftquestion++; 
                } else { 
                    rightquestion++; 
                } 
            } else { 
                if(i < n/2){ 
                    // FIXED: Changed num[i] to num.charAt(i)
                    leftsum += num.charAt(i) - '0'; 
                } else { 
                    // FIXED: Changed num[i] to num.charAt(i)
                    rightsum += num.charAt(i) - '0'; 
                } 
            } 
        } 
        
        int totalmarks = leftquestion + rightquestion; 
        if(totalmarks % 2 == 1){ 
            return true; 
        } 
        
        int left = 2 * leftsum + 9 * leftquestion; 
        int right = 2 * rightsum + 9 * rightquestion; 
        
        if(left == right){ 
            return false; 
        } 
        return true; 
    } 
}
