package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        boolean[] mem= new boolean[Math.max(n+1,4)];
        mem[0]=false;mem[1]=true;mem[2]=true;mem[3]=false;
        if(n<4) return mem[n];
        for(int i=4;i<=n;i++)
        // key !! Max(a take 1 -- Min(b take 1 (what a get), b take 2), a take 2 -- Min(b take 1, b take 2))
        mem[i]=mem[i-2]&&mem[i-3]||mem[i-3]&&mem[i-4];// maximin
        return mem[n];
    }
    // public boolean minimax(int[] mem, int n){
    //     if(mem[n]!=0) return mem[n]==1?true:false;
    //     if(n==0) return false;
    //     if(n==1) return true;
    //     if(n==2) return true;
    //     if(n==3) return false;
    //     boolean ans=(minimax(mem,n-2)&&minimax(mem,n-3))||(minimax(mem,n-3)&&minimax(mem,n-4));
    //     mem[n]=ans?1:2;
    //     return ans;
    // }
    // public boolean firstWillWin(int n) {
    //     // write your code here
    //     int[] mem= new int[n+1];
    //     return minimax(mem,n);
    // }
}