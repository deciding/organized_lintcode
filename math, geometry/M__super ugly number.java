public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        int k=primes.length;
        int[] ans= new int[n], cand=new int[k];
        ans[0]=1;
        for(int i=1;i<n;i++) ans[i]=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
	       for(int j=0;j<k;j++)
	           ans[i]=Math.min(ans[i],ans[cand[j]]*primes[j]);
	       for(int j=0;j<k;j++)
	       if(ans[cand[j]]*primes[j]==ans[i]) cand[j]++;// everyone move ahead
        }
        return ans[n-1];
    }
}
