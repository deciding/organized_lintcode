package lintcode;
import java.util.*;
//DP!
//public class Solution {
//    /**
//     * @param A: A list of lists of integers
//     * @return: An integer
//     */
//    public int jump(int[] A) {
//        // write your code here
//        int[] mem= new int[A.length];
//        for(int i=1;i<A.length;i++)
//        mem[i]=Integer.MAX_VALUE;
//        mem[0]=0;
//        for(int i=0;i<A.length;i++)
//        for(int j=1;j<=A[i];j++)
//        if(mem[i]!=Integer.MAX_VALUE&&i+j<A.length)
//        mem[i+j]=Math.min(mem[i+j],mem[i]+1);
//        return mem[mem.length-1]!=Integer.MAX_VALUE?mem[mem.length-1]:-1;
//    }
//}
public class Solution {
	public static int jump(int[] A) {
        // write your code here
        int steps=0;
        int max=0;
        int stepa=0,stepb=0;
        // key !! step means min step, [stepa,stepb] means what is the range which is reachable 
        //when min steps is 'step'(step-1 cannot reach).
        while(stepb<A.length-1){
            if(stepa>stepb) return -1;
            steps++;
            for(int i=stepa;i<=stepb;i++)
            max=Math.max(max,i+A[i]);
            stepa=stepb+1;
            stepb=max;
        }
        return steps;
    }
    public static void main(String[] args){
    	System.out.println(jump(new int[]{1,1,1,1,1,0,1,1}));
    }
}