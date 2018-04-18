public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if(costs==null||costs.length==0) return 0;
        for(int i=1;i<costs.length;i++)
        for(int j=0;j<3;j++){
            costs[i][j]+=Math.min(costs[i-1][(j+1)%3],costs[i-1][(j+2)%3]);
        }
        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}
