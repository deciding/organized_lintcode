//O(n) O(1) space, in-place
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void reverse(ArrayList<Integer> nums,int m, int n){
        while(m<n){
            int temp=nums.get(m);
            nums.set(m,nums.get(n));
            nums.set(n,temp);
            m++;
            n--;
        }
    }
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if(nums.size()<=1) return;
        for(int i=0;i<nums.size()-1;i++)
            if(nums.get(i)>nums.get(i+1)){
                reverse(nums,0,i);
                reverse(nums,i+1,nums.size()-1);
                reverse(nums,0,nums.size()-1);
                return;
            }
    }
}