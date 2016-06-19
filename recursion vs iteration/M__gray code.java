package lintcode;
import java.util.*;
//clever recursion !
// intro !! only one bit different, input n: how many bits
public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public static ArrayList<Integer> grayCode(int n) {
        // Write your code here
    	ArrayList<Integer> ans=new ArrayList<Integer>();
    	if(n==0){
    		ans.add(0);
    		return ans;
    	}
    	ans=grayCode(n-1);
    	int size= ans.size();
    	int MSB=1<<(n-1);
    	for(int i=size-1;i>=0;i--)
    		ans.add(ans.get(i)+MSB);
        return ans;
    }
    public static void main(String[] args){
    	grayCode(5);
    }
}