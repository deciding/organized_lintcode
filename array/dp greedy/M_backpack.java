public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    //e.g. [2, 3, 5, 7] with size 11
    // from m to 1, is just for O(m) mem, not O(m*n). this trick can only be used when 
    //we only get data from left diagnol of matrix !!
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] size=new boolean[m+1];
        size[0]=true;
        for(int i=0;i<A.length;i++)
        for(int j=m;j>=1;j--)
        if(j-A[i]>=0&&size[j-A[i]])size[j]=true;
        for(int i=m;i>=0;i--)
        if(size[i])return i;
        return -1;
    }
}