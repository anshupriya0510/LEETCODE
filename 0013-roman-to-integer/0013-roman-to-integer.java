class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I' && ((i+1)<s.length() && s.charAt(i+1)=='V')){
                sum+=4;
                i++;
            }
            else if(s.charAt(i)=='I' && ((i+1)<s.length() && s.charAt(i+1)=='X')){
                sum+=9;
                i++;
            }
            else if(s.charAt(i)=='I'){
                sum+=1;
            }
            else if(s.charAt(i)=='V'){
                sum=sum+5;
            }
            else if(s.charAt(i)=='X' && ((i+1)<s.length() && s.charAt(i+1)=='L')){
                sum=sum+40;
                i++;
            }
            else if(s.charAt(i)=='X' && ((i+1)<s.length() && s.charAt(i+1)=='C')){
                sum=sum+90;
                i++;
            }
            else if(s.charAt(i)=='X' ){
                sum=sum+10;
            }
            else if(s.charAt(i)=='L'){
                sum=sum+50;
            }
            else if(s.charAt(i)=='C'&& ((i+1)<s.length() && s.charAt(i+1)=='D')){
                sum=sum+400;
                i++;
            }
            else if(s.charAt(i)=='C' && ((i+1)<s.length() && s.charAt(i+1)=='M')){
                sum=sum+900;
                i++;
            }
            else if(s.charAt(i)=='C'){
                sum=sum+100;
            }
            else if(s.charAt(i)=='D'){
                sum=sum+500;
            }
            else if(s.charAt(i)=='M'){
                sum=sum+1000;
            }
            
        }
        return sum;
    }
}