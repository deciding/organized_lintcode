public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public int getHappyNumber(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d*d;
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        // Write your code here
        HashSet<Integer> hs=new HashSet<Integer>();
        while(!hs.contains(n)){
            hs.add(n);
            n=getHappyNumber(n);
            if(n==1) return true;
        }
        return false;
    }
}