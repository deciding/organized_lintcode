public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int LSOne(int num){
        return num&(-num);
    }
    public int countOnes(int num) {
        // write your code here
        int ans=0;
        while(num!=0)
        {
            num-=LSOne(num);
            ans++;
        }
        return ans;
    }
};
