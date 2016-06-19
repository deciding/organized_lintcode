//fibonacci
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
	public static int climbStairs(int n) {
        // write your code here
        if(n<=1) return 1;
        int cur=0,prev=1,prevprev=1;
        for(int i=2;i<=n;i++){
            cur=prev+prevprev;
            prevprev=prev;
            prev=cur;
        }
        return cur;
    }
}
