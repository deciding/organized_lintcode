//in-place, two pointers
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if(nums.length==0) return;
        int firstEven=0, oddFinder=0;
        while(firstEven<nums.length&&nums[firstEven]%2!=0){
            firstEven++;
        }
        oddFinder=firstEven+1;
        while(oddFinder<nums.length){
           if(nums[oddFinder]%2!=1) oddFinder++;
           else {
               int temp=nums[oddFinder];
               nums[oddFinder]=nums[firstEven];
               nums[firstEven]=temp;
               firstEven++;
               oddFinder++;
           }
        }
    }
}
