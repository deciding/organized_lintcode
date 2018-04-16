public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        double[][] mem= new double[n][6*n];
        for(int i=0;i<6;i++)
        mem[0][i]=1/6.0;
        for(int i=1;i<n;i++)
        for(int j=i;j<(i+1)*6;j++)
        for(int k=1;k<=6;k++)
        if(j-k>=0) mem[i][j]+=mem[i-1][j-k]/6.0;
        ArrayList<Map.Entry<Integer, Double>> ans= new ArrayList<>();
        for(int i=n-1;i<6*n;i++)
        ans.add(new AbstractMap.SimpleEntry<Integer, Double>(i+1, mem[n-1][i]));
        return ans;
    }
}
