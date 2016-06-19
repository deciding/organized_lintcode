// actually only have numbers 1,2,3 nnnn is impossible
import java.util.*;
public class Solution {
//	  public static class TreeNode {
//	      public int val;
//	      public TreeNode left, right;
//	      public TreeNode(int val) {
//	          this.val = val;
//	          this.left = this.right = null;
//	      }
//	  }
	public static String countAndSay(int n) {
        // Write your code here
		if(n==1) return "1";
		String result="";
		int count=1;
		String str=countAndSay(n-1);// !! recursion
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1))count++;
			else {
				result+=(count+""+str.charAt(i));// !! key
				count=1;
			}
		}
		result+=(count+""+str.charAt(str.length()-1));// last set of digit
		return result;
    }
    public static void main(String args[]){
//    	Scanner sc=new Scanner(System.in);
//    	String a=sc.next();
    	System.out.println(countAndSay(4));
//    	String b=sc.next();
//    	sc.close();
    }
}