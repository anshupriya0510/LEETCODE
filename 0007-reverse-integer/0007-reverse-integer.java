class Solution {
    public int reverse(int x) {
        long revsum = 0;
        while(x!=0){
            int lastnum = x % 10;
            revsum = revsum * 10 + lastnum;
            x = x/10;
        }
        if(revsum<Integer.MIN_VALUE ||revsum>Integer.MAX_VALUE ){
        return 0;
    } else {
        return (int)revsum;
    }
    }
}