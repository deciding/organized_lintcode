//quick select, mind rank for checking and right sub recursion
// test case 4 5 1 2 3
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
     int quickselect(int[] nums, int left, int right,int rank){
	            if(left==right&&rank==1) return nums[left];
	            int mid=(left+right)/2;
	            int pivot=nums[mid];
	            int temp;
	            temp=nums[mid];
	            nums[mid]=nums[left];
	            nums[left]=temp;
	            int p=left+1;
	            for(int i=left+1;i<right+1;i++){
	                if(nums[i]<pivot) {
	                    temp=nums[i];
	                    nums[i]=nums[p];
	                    nums[p]=temp;
	                    p++;
	                }
	            }
	            temp=nums[left];
	            nums[left]=nums[p-1];
	            nums[p-1]=temp;
	            if(p-left==rank) return nums[p-1];
	            else if(p-left>rank) return quickselect(nums, left,p-2,rank);
	            else return quickselect(nums,p,right,rank-(p-left));
	        }
    public int median(int[] nums) {
        // write your code here
        
        return quickselect(nums,0,nums.length-1,(nums.length+1)/2);
    }
}

