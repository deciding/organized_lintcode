public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
         // write your code here
        int ans=0;
        int[] size=new int[m+1];
        for(int i=0;i<A.length;i++)
        for(int j=m;j>=1;j--)
        if(j-A[i]==0||j-A[i]>0&&size[j-A[i]]>0) size[j]=Math.max(size[j], size[j-A[i]]+V[i]);
        for(int i=m;i>=0;i--)
        ans=Math.max(ans, size[i]);
        return ans;
    }
}