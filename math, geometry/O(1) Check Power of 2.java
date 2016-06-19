//0 and min neg number are the special cases
class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public int LSOne(int n){
        return n&(-n);
    }
    public boolean checkPowerOf2(int n) {
        // write your code here
        // key !! 0 is not, Integer.MIN_VALUE= 1000000000000...
        if(n==0||n==-2147483648) return false;
        return (n-LSOne(n))==0;
    }
};