import java.util.*;
// key !!
class Sum implements Comparable<Sum>{
	int index;
	int sum;
	public Sum(int i,int s){
		index=i;
		sum=s;
	}
	public int compareTo(Sum x){
		return sum-x.sum;
	}
}
// key !! same idea as subarray sum, but since closest to zero, need to sort !!
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public static int[] subarraySumClosest(int[] nums) {
        // write your code here
    	if(nums==null||nums.length==0) return new int[]{0,0};
    	Sum[] sum=new Sum[nums.length+1];
    	int[] ans=new int[2];
    	int total=0;
    	for(int i=0;i<nums.length;i++){
    		total+=nums[i];
    		sum[i]=new Sum(i,total);
    	}
    	sum[nums.length]=new Sum(-1,0);
        // key !! only useful for closest to ZERO !!
    	Arrays.sort(sum);
    	int min=Integer.MAX_VALUE;
    	int index=1;
    	for(int i=1;i<sum.length;i++)
    		if(Math.abs(sum[i].sum-sum[i-1].sum)<min){
    			min=Math.abs(sum[i].sum-sum[i-1].sum);
    			index=i;
    		}
    	int i1=sum[index-1].index,i2=sum[index].index;
    	if(i1<i2){
    		ans[0]=i1+1;
    		ans[1]=i2;
    	}
    	else {
    		ans[0]=i2+1;
    		ans[1]=i1;
    	}
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(Arrays.toString(subarraySumClosest(new int[]{Integer.MAX_VALUE})));
    }
}
