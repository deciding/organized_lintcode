package lintcode;
import java.util.*;

// key !! allow rotate
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
	//method 1 copy array ! I have no idea how to do it
	//method 2 one for max sum, one for total-min sum !
	public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        int sum=0, total=0;
        int a=0,atmp=0,b=0;
        int x=0,xtmp=0,y=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
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
        sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(sum<min){
                min=sum;
                x=xtmp;
                y=i;
            }
            if(sum>0) {
                sum=0;
                xtmp=i+1;
            }
        }
        for(int i=0;i<A.length;i++)
        	total+=A[i];
        ArrayList<Integer> ans= new ArrayList<Integer>();
        if(max>=total-min||x==0&&y==A.length-1){// in case all negative
	        ans.add(a);
	        ans.add(b);
        }
        else {
        	ans.add(y+1);
	        ans.add(x-1);
        }
        return ans;
    }
}