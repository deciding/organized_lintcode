public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
    	int n=A.length;
    	int[][] mem= new int[k+1][target+1];// target is involed, so must be pos numbers, 0 also cannot, since it will make base case kk=0 complicated
    	mem[0][0]=1;
		for(int i=0;i<n;i++)
			for(int j=k;j>0;j--)//change 1, and lvl 0 are already correct values
	    		for(int kk=A[i]; kk<=target;kk++)//change 2
	    			mem[j][kk]+=mem[j-1][kk-A[i]];
    	return mem[k][target];
    }
}
