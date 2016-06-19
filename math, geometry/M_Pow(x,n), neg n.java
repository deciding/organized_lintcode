import java.util.*;
public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public static double myPow(double x, int n) {
        // Write your code here
    	boolean neg=n<0;
    	x=neg?1/x:x;
    	n=Math.abs(n);
    	if(n==0) return 1.0;
    	if(n==1) return x;
    	if(n==2) return x*x;
    	if(n%2==0)return myPow(myPow(x,n/2),2);
    	return myPow(myPow(x,n/2),2)*x;
    }
    public static void main(String[] args){
    	System.out.println(myPow(6,-5));
    }
}