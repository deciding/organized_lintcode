//very simple
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
	 
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> st= new Stack<TreeNode>();
        ArrayList<Integer> result= new ArrayList<Integer>();
        if(root==null) return result;
        TreeNode cur;
        st.push(root);
        while(!st.isEmpty()){
        	cur=st.pop();
        	result.add(cur.val);
          // right, left !!
        	if(cur.right!=null) st.push(cur.right);
        	if(cur.left!=null) st.push(cur.left);
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
