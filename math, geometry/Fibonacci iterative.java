class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n<=2) return n-1;
        int cur=0,prev=1,prevprev=0;
        for(int i=3;i<=n;i++){
            cur=prev+prevprev;
            prevprev=prev;
            prev=cur;
        }
        return cur;
    }
}


