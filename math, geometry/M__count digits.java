package lintcode;
import java.util.*;

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
	//0,99->10  2,302->161
    public static int digitCounts(int k, int n) {
        //bit: bit we are counting
        //high bits(+1): how many chances it will be k
        //factor(+low bits +1): how many continues time for bit to be k in one chance
        // write your code here
        int count=0;
        int factor=1;
        int bit, high_bits,low_bits;
        while(n/factor!=0){
            bit=n/factor%10;
            high_bits=n/factor/10;
            low_bits=n-n/factor*factor;
            if(bit<k)
            count+=high_bits*1*factor;//high-bit-low
            else if(bit>k){
            if(k==0&&(high_bits==0&&factor!=1)) {//e.g 15 when bit==1
                factor*=10;
                continue;
            }
            count+=(high_bits+1)*1*factor;
            }
            else count+=(high_bits*1*factor+low_bits+1);//+1: 10,11,12, 2+1=3
            factor*=10;
        }
        return count;
    }
    public static void main(String[] args){
    	System.out.println(digitCounts(0,9));
    }
};
