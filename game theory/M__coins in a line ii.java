package lintcode;
import java.util.*;
public class Solution {
    // current accumulate val is based on prev two itr
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n=values.length;
        int sum=0;
        for(int i=0;i<n;i++)
        sum+=values[i];
        
        if(n==0) return false;
        if(n==1) return true;
        if(n==2) return true;
        if(n==3) return values[0]+values[1]>values[2];
        
        int[] mem=new int[values.length+1];// key !! from back !!
        mem[0]=0;
        mem[1]=values[n-1];
        mem[2]=values[n-2]+values[n-1];
        mem[3]=values[n-3]+values[n-2];
        for(int i=4;i<=values.length;i++)
        mem[i]=Math.max(Math.min(mem[i-2],mem[i-3])+values[n-i],
                        Math.min(mem[i-3],mem[i-4])+values[n-i]+values[n-i+1]);
        return mem[values.length]*2>sum;
    }
}
    // public int minimax(int[] mem, BitSet assigned, int[] values, int n){
    //     if(assigned.get(n)) return mem[n];
    //     if(n==0) return 0;
    //     if(n==1) return values[values.length-1];
    //     if(n==2) return values[values.length-1]+values[values.length-2];
    //     if(n==3) return values[values.length-2]+values[values.length-3];
    //     assigned.set(n);
    //     return mem[n]=Math.max(Math.min(minimax(mem,assigned,values,n-2),minimax(mem,assigned,values,n-3))+values[values.length-n],Math.min(minimax(mem,assigned,values,n-3),minimax(mem,assigned,values,n-4))+values[values.length-n]+values[values.length-n+1]);
    // }
    // public boolean firstWillWin(int[] values) {
    //     // write your code here
    //     int n=values.length+1;
    //     BitSet assigned=new BitSet();
    //     int[] mem=new int[n];
    //     int s=0;
    //     for(int i=0;i<n-1;i++)
    //     s+=values[i];
    //     return minimax(mem,assigned,values,n-1)*2>s;
    // }
}
