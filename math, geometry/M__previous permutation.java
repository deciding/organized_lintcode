import java.util.*;
//213->132
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public static ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		int i,j;
    	for(i=nums.size()-2;i>=0;i--)
    		if(nums.get(i)>nums.get(i+1)){
    		for(j=nums.size()-1;j>i;j--)
    			if(nums.get(i)>nums.get(j)) break;
    		//swap
    		int tmp=nums.get(i);
    		nums.set(i, nums.get(j));
    		nums.set(j, tmp);
    		break;
    		}
    	//reverse
    	for(int a=i+1;a<i+1+(nums.size()-i-1)/2;a++){
    		int tmp=nums.get(a);
    		nums.set(a, nums.get(nums.size()-a+i));
    		nums.set(nums.size()-a+i, tmp);
    	}
    	return nums;
    }
    public static void main(String[] args){
    	ArrayList arr= new ArrayList<Integer>(Arrays.asList(1,2,5,1,2,2,3));
    	System.out.println(previousPermuation(arr));
    }
}
