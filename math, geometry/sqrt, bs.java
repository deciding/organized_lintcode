package lintcode;
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long start=0;
        long end =x;
        while(start+1<end){
            long mid = (start+end)/2;
            if(mid*mid==x) return (int)mid;
            if(mid*mid<x) start=mid;
            else end=mid;
        }
        if(start*start==x)return (int)start;
        if(end*end==x) return (int)end;
        return (int)start;
    }
}