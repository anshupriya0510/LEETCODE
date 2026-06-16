/*import java.util.*;*/
class Solution {
    public int fib(int n) {
        if(n==0||n==1){
            return n;
        }
       int  a = fib(n-1);
       int b = fib(n-2);
        int c = a+b;
        return(c);
        //return fib(b,c,(n-1));//
        
    }
}
    /* public static void main(String args[]);{
     Scanner sc = new scanner(System.in);
     a = 0; b = 1;
     System.out.println(a);
     System.out.println(b);
     int n = sc.nextInt();
     fib(a,b,(n-2)
     
     }*/
    