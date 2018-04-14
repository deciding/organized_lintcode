public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int count=1;
        if(nums.length<=1) return nums.length;
        int index=1;
        for(int i=1;i<nums.length;i++)
            if(nums[i]!=nums[i-1]){
                nums[index++]=nums[i];
                count=1;
            }
            else if(count==1){
                nums[index++]=nums[i];
                count++;
            }
        return index;
    }
}
