import java.util.*;

//class Solution {
//    /**
//     * @param k: The number k.
//     * @return: The kth prime number as description.
//     */
//	public static boolean check(int n){
//		while(n%3==0) n/=3;
//		while(n%5==0) n/=5;
//		while(n%7==0) n/=7;
//		return n==1;
//	}
//    public long kthPrimeNumber(int k) {
//        // write your code here
//    	return 1;
//    }
//    public static void main(String[] args){
//    	for(int i=1;i<100;i++)
//    		if(check(i)) System.out.print(i+" ");
//    }
//};

//1. heap, poll 1 element, *3 *5 *7 push into heap, also need hashmap to check whether already have the number
//2. index3 index5 index7
public class Solution {
	public static long kthPrimeNumber(int k) {
        // write your code here
		long[] nums= new long[k+1];
		nums[0]=1;
		int index3=0,index5=0,index7=0;
		int index=1;
		while(index<=k){
			nums[index++]=Math.min(nums[index3]*3, Math.min(nums[index5]*5, nums[index7]*7));
			if(nums[index-1]==nums[index3]*3) index3++;//no else , in case, same min
			if(nums[index-1]==nums[index5]*5) index5++;
			if(nums[index-1]==nums[index7]*7) index7++;
		}
		return nums[k];
    }
    public static void main(String[] args){
    	System.out.println(kthPrimeNumber(6));
    }
}
