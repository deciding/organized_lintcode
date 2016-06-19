package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
        if(numbers.length<4) return ans;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-3;i++){
        	if(i!=0&&numbers[i-1]==numbers[i]) continue;//avoid duplicates
	        for(int j=i+1;j<numbers.length-2;j++){
	            if(j!=i+1&&numbers[j-1]==numbers[j]) continue;//avoid duplicates
	            int a=j+1,b=numbers.length-1;
	            while(a<b){
	                int sum=numbers[i]+numbers[j]+numbers[a]+numbers[b];
	                if(sum==target){
	                    ArrayList<Integer> temp= new ArrayList<Integer>();
	                    temp.add(numbers[i]);temp.add(numbers[j]);temp.add(numbers[a]);temp.add(numbers[b]);
	                    ans.add(temp);
	                    a++;b--;
	                    while(numbers[a]==numbers[a-1]&&a<b) a++;//avoid duplicates
	                    while(numbers[b]==numbers[b+1]&&a<b) b--;//avoid duplicates
	                }
	                else if(sum<target) a++;
	                else b--;
	            }
	        }
        }
        return ans;
    }
}