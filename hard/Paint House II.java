public class Solution {
    // n houses, k colors, n*k cost, no two adj same color, min cost
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
        if(costs==null) return 0;
        int n=costs.length;
        if(n==0) return 0;
        int k=costs[0].length;
        if(k==0) return 0;
        int[] leftMin=new int[k],rightMin=new int[k];
        for(int i=0;i<n;i++){
            if(i!=0)
            for(int j=0;j<k;j++)
                costs[i][j]+=Math.min(leftMin[j],rightMin[j]);
            for(int x=0;x<k;x++)
                if(x==0) leftMin[x]=Integer.MAX_VALUE;
                else leftMin[x]=Math.min(leftMin[x-1],costs[i][x-1]);
            for(int x=k-1;x>=0;x--)
                if(x==k-1) rightMin[x]=Integer.MAX_VALUE;
                else rightMin[x]=Math.min(rightMin[x+1],costs[i][x+1]);
        }
        return Math.min(leftMin[k-1],costs[n-1][k-1]);
    }
}
