public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        int[] mem=new int[n+1];
        for(int i=1;i<=n;i++)
        mem[i]=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int x=(int)Math.sqrt(i);
            for(int j=1;j<=x;j++)
            mem[i]=Math.min(mem[i],1+mem[i-j*j]);
        }
        return mem[n];
    }
}
