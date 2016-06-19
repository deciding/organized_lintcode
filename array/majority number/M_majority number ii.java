package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    //throw three numbers: current, cand1, cand2 !!
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int cand1=0,cand2=0,cnt1=0,cnt2=0;
        for(int i=0;i<nums.size();i++){
            int num=nums.get(i);
            if(num==cand1) cnt1++;
            else if(num==cand2) cnt2++;
            else if(cnt1==0) {
                cand1=num;
                cnt1++;
            }
            else if(cnt2==0) {
                cand2=num;
                cnt2++;
            }
            else{
                cnt1--;cnt2--;
            }
        }
        cnt1=cnt2=0;
        for(int i=0;i<nums.size();i++)
        if(nums.get(i)==cand1) cnt1++;
        else if(nums.get(i)==cand2) cnt2++;
        return cnt1>cnt2?cand1:cand2;
    }
}
