class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    //for binary search remember a==start, b==end are the special cases
    public long binarySearch(int[] nums, int target) {
        //write your code here
        int a=0,b=nums.length-1;
        while(a+1<b){
            int mid=a+(b-a)/2;// in case overflow
            if(nums[mid]>=target) b=mid;
            else a=mid;
        }
        if(nums[a]==target) return a;
        if(nums[b]==target) return b;
        return -1;
    }
}
