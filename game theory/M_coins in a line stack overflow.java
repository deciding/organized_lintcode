package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean dp(int[] mem, boolean zn1, int n) {
        if(n==0)mem[n]=2;
        else if(n==1)mem[n]=1;
        boolean ans;
        if(zn1){
            if(mem[n]!=0) return mem[n]==1?true:false;
            ans=dp(mem,!zn1,n-1)||dp(mem,!zn1,n-2);
            mem[n]=ans?1:2;
            return ans;
        }
        if(mem[n]!=0) return mem[n]==1?false:true;
        ans=!(dp(mem,!zn1,n-1)&&dp(mem,!zn1,n-2));
        mem[n]=ans?1:2;
        return !ans;
    }
    public boolean firstWillWin(int n) {
        // write your code here
        int[] mem= new int[n+1];
        boolean zn1=true;
        return dp(mem,zn1,n);
    }
}