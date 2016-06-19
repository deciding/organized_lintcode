//because not using the node immediately, need cur to record whether go left or go right
import java.util.*;
public class Solution {

  public static class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
     }
  }
	 
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> st= new Stack<TreeNode>();
        ArrayList<Integer> result= new ArrayList<Integer>();
        TreeNode cur=root;
        while(!st.isEmpty()||cur!=null){
        	if(cur==null){
        		cur=st.pop();
        		result.add(cur.val);
        		cur=cur.right;
        	}
        	else{
        		st.push(cur);
        		cur=cur.left;
        	}
        	
        }
        return result;
    }
    
    public static void main(String args[]){
    	 TreeNode root= new TreeNode(1);
    	 root.right= new TreeNode(2);
    	 root.right.left= new TreeNode(3);
    	 System.out.println(preorderTraversal(root));
    }
}
