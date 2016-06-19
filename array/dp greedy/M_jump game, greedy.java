package lintcode;
import java.util.*;
//DP!
//public class Solution {
//    /**
//     * @param A: A list of integers
//     * @return: The boolean answer
//     */
//    public boolean canJump(int[] A) {
//        // wirte your code here
//        boolean[] mem=new boolean[A.length];
//        mem[0]=true;
//        for(int i=0;i<A.length;i++)
//        for(int j=1;j<=A[i];j++)
//        if(mem[i]&&i+j<A.length) mem[i+j]=true;
//        return mem[mem.length-1];
//    }
//}
//Greedy!
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int max=A[0];
        for(int i=0;i<A.length;i++)
        if(i<=max&&i+A[i]>max) max=i+A[i];
        return max>=A.length-1;
    }
}