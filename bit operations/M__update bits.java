import java.util.*;

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public static int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask=1;
        // key !! special case 
        if(j<31) mask=~((1<<(j+1))-(1<<i));//1111000001111
        else mask=(1<<i)-1;
        return (m<<i)|(n&mask);
    }
    public static void main(String[] args){
    	System.out.println(updateBits(-521,0,31,31));
    }
}
