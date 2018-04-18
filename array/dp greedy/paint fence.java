public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if(n==0) return 0;
        if(n==1) return k;
        if(n==2) return k*k;
        int pp=1;
        int p=k;
        int cur=0;
        for(int i=3;i<=n;i++){
            cur=p*(k-1);//diff color with prev
            cur+=pp*(k-1);//same color with prev
            pp=p;p=cur;
        }
        return cur*k;
    }
}
