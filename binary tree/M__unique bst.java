import java.util.*;

//structurally different mean use diff number as root for BST
//catalan number: ABCD pushed in stack in this order, how many ways are they poped?( parenthesis also)
public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public static int numTrees(int n) {
        // write your code here
    	int[] num= new int[n+1];
    	num[0]=1;
    	for(int i=1;i<=n;i++)
    		for(int j=0;j<i;j++)
    			num[i]+=num[j]*num[i-1-j];
    	return num[n];
    }
    public static void main(String[] args){
    	System.out.println(numTrees(3));
    }
}