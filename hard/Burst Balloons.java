public class Solution {
    // range i, j. No longer steps as dimension
    // like palindrome
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
        //逆向思维
        int n=nums.length;
        int[][] mem= new int[n+2][n+2];
        int[] myNums=new int[n+2];
        myNums[0]=1;myNums[n+1]=1;
        for(int i=1;i<n+1;i++)
        myNums[i]=nums[i-1];
        
        for(int i=n;i>0;i--)
        for(int j=i;j<n+1;j++)
        for(int x=i;x<=j;x++)//the last balloon burst within this range
            mem[i][j]=Math.max(mem[i][j],myNums[x]*myNums[i-1]*myNums[j+1]+mem[i][x-1]+mem[x+1][j]);
        return mem[1][n];
    }
}
