package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num.length==0) return -1;
        if(num.length==1) return 0;
        int a=0,b=num.length-1;
        while(a+1<b){
            int mid=(a+b)/2;
            if(num[mid]<num[num.length-1])
            b=mid;
            else a=mid;
        }
        if(num[a]<num[num.length-1]) return num[a];
        else return num[b];
    }
}