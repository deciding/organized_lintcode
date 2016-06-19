public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    // key: in place !! return new length
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums.length<=1) return nums.length;
        int index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1])
                nums[index++]=nums[i];
        }
        return index;
    }
}