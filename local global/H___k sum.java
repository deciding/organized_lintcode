import java.util.Arrays;
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
	// dp: mem shape->1 element example->process order-> base case
	// can also be seen as local, global: kth element is this one(local), kth element is not this cell(global)
	// similar to string/num of distinct subsequence
	//3d dp
//    public int kSum(int A[], int k, int target) {
//        // write your code here
//    	int n=A.length;
//    	int[][][] mem= new int[k+1][n+1][target+1];// target is involed, so must be pos numbers, 0 also cannot, since it will make base case kk=0 complicated
//    	for(int i=0;i<=n;i++)
//    		mem[0][i][0]=1;// base case: we take 0 numbers the sum is 0, possible cases is 1
//    	for(int i=1;i<=k;i++)
//    		for(int j=1;j<=n;j++)
//	    		for(int kk=1; kk<=target;kk++){
//	    			mem[i][j][kk]=mem[i][j-1][kk];//global-local
//	    			if(kk-A[j-1]>=0) mem[i][j][kk]+=mem[i-1][j-1][kk-A[j-1]];//local
//	    		}
//    	return mem[k][n][target];
//    }
	
	//compressed
	// we go through A element by element with each element has a k*target matrix
	// since each matrix will only use above 1 lvl element matrix, we donot need to keep 3d dp
	// but need to keep k in decreasing order !! since we need to use the previous elements' k-1 lvl cell
	// no need to copy the mem[i][j-1][kk] all over, since we use +=, that value is already there
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
