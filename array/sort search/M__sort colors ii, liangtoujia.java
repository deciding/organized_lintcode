import java.util.*;

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    // can use count sort instead
	public static void swap(int[] nums, int i, int j){
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}
	public static void sortColors2(int[] colors, int k) {
        // write your code here
		int cnt=0;
		int l=0,r=colors.length-1;
		while(cnt<k/2){
	    	int i=l;
	    	while(i<=r){
	    		if(colors[i]==1+cnt){
	    			swap(colors,i,l);
	    			i++;
	    			l++;
	    		}
	    		else if(colors[i]==k-cnt){
	    			swap(colors,i,r);
	    			r--;
	    		}
	    		else i++;
	    	}
	    	cnt++;
		}
    }
	public static void main(String[] args){
		int[] arr=new int[]{3, 2, 2, 4};
		sortColors2(arr,4);
		System.out.println(Arrays.toString(arr));
	}
}