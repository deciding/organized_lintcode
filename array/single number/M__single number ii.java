import java.util.*;

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public static int singleNumberII(int[] A) {
        // write your code here
    	int[] bits= new int[32];
    	for(int i=0;i<A.length;i++)
    		for(int j=0;j<32;j++)
    			if((A[i]&(1<<j))!=0)
    				bits[j]=(bits[j]+1)%3;
    	int ans=0,bit=1;
    	for(int i=0;i<32;i++){
    		if(bits[i]==1)
    			ans|=bit;
    		bit=bit<<1;
    	}
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(singleNumberII(new int[]{-1,2,2,-1,-1,2,-3}));
    }
}