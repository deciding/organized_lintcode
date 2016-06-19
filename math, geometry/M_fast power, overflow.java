package lintcode;
import java.util.*;

// intro !! a^n%b
class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n==0) return 1%b;
        long x=fastPower(a,b,n/2);//...
        long ans=x*x%b;//...
        if(n%2==1) ans=a%b*ans%b;
        return (int)ans;
    }
};