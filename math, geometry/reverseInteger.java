package lintcode;

// !! overflow
public class Solution {
	public int reverseInteger(int n) {
        // Write your code here
        long sum=0;
        int max=0x7fffffff;
        int min=0x80000000;
        while(n!=0){
            sum=sum*10+n%10;
            n/=10;
        }
        if(sum>max||sum<min) return 0;
        return (int)sum;
    }
}
