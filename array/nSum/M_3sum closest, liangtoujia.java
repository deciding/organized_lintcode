package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        int ans=Integer.MAX_VALUE;
        if(numbers.length<3) return ans;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-2;i++){
            if(i!=0&&numbers[i-1]==numbers[i]) continue;
            int a=i+1,b=numbers.length-1;
            while(a<b){
                int sum=numbers[i]+numbers[a]+numbers[b];
                if(Math.abs(sum-target)<Math.abs(ans-target))
                    ans=sum;
                if(sum==target)
                    return sum;
                else if(sum<target) a++;
                else b--;
            }
        }
        return ans;
    }
}