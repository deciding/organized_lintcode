package lintcode;
import java.util.*;
//complicated logic !
public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    // key !! 3 conditions
    // 1. if this gas-cost>0 it will be a candidate
    // 2. if total becomes smaller sometimes after that candidate, the candidate will be cancelled
    // 3. if at the end total<0, not possible
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int sum=0,total=0;
        int index=-1;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if(sum<0){
                sum=0;
                index=i;
            }
        }
        return total>=0&&index+1<gas.length?index+1:-1;
    }
}