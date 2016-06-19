package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        int sum=0;
        int a=0,atmp=0,b=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(sum>max){
                max=sum;
                a=atmp;
                b=i;
            }
            if(sum<0) {
                sum=0;
                atmp=i+1;
            }
        }
        ArrayList<Integer> ans= new ArrayList<Integer>();
        ans.add(a);ans.add(b);
        return ans;
    }
}