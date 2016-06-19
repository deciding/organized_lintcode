//two stack, much easier, but left first, right then. another stack is for reversing order
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
	 
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> st= new Stack<TreeNode>();
        Stack<TreeNode> st2= new Stack<TreeNode>();
        ArrayList<Integer> result= new ArrayList<Integer>();
        if(root==null) return result;
        TreeNode cur=root;
        st.push(root);
        while(!st.isEmpty()){
        	cur=st.pop();
        	st2.push(cur);
        	if(cur.left!=null)st.push(cur.left);
        	if(cur.right!=null)st.push(cur.right);
        }
        while(!st2.isEmpty()) result.add(st2.pop().val);
        return result;
    }
    
    public static void main(String args[]){
    	 TreeNode root= new TreeNode(1);
    	 root.right= new TreeNode(2);
    	 root.right.left= new TreeNode(3);
    	 System.out.println(postorderTraversal(root));
    }
}
