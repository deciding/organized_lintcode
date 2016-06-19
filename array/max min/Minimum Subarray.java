//reverse of max 1d sum
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int sum=0;
        int min=nums.get(0);
        for(int i=0;i<nums.size();i++){
            sum+=nums.get(i);
            if(min>sum) min=sum;
            if(sum>0) sum=0;
        }
        return min;
    }
}

