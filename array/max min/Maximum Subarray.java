//if there are all negative numbers, only if we record first then replace with 0, we can have that
//biggest neg number
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        int max=nums.get(0);
        int sum=0;
        for(int i=0;i<nums.size();i++){
            sum+=nums.get(i);
            if(sum>max){
                max=sum;
            }
            else if(sum<0) sum=0;
        }
        return max;
    }
}
