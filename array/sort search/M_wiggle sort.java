public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    void swap(int[] nums, int i,int j){
        int tmp=nums[i];nums[i]=nums[j];nums[j]=tmp;
    }
    public void wiggleSort(int[] nums) {
        // Write your code here
        int n=nums.length;
        if(n==0) return;
        for(int i=1;i<nums.length;i++)
            if(i%2==1&&nums[i]<nums[i-1]||i%2==0&&nums[i]>nums[i-1]) swap(nums,i,i-1);
    }
}
