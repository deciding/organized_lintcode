public class Solution {
    //minimax k subarr sum
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        int n=pages.length;
        int[] sum=new int[n+1];
        int[][] mem=new int[k+1][n+1];
        for(int i=1;i<=n;i++)
            mem[1][i]=sum[i]=sum[i-1]+pages[i-1];
        for(int i=2;i<=k;i++)
            for(int j=1;j<=n;j++)
                mem[i][j]=Integer.MAX_VALUE;
        for(int i=2;i<=k;i++){
            int l=0,r=1;
            while(l<n&&r<=n){
                mem[i][r]=Math.min(mem[i][r],Math.max(mem[i-1][l],sum[r]-sum[l]));
                if(l==r-1||sum[r]-sum[l]<=mem[i-1][l]) r++;
                else l++;
            }
        }
        return mem[k][n];
    }
}
