//much more difficult, since no tail recursion. right first root then, 
// because we need to know the root info first when pop back, after which we can 
//rearrange the order
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
        ArrayList<Integer> result= new ArrayList<Integer>();
        TreeNode cur=root;
        while(!st.isEmpty()||cur!=null){
        	if(cur==null){
        		cur=st.pop();
        		if(cur.right==null||st.isEmpty()||st.peek()!=cur.right) {
        			result.add(cur.val);
        			cur=null;
        		}
        		else {
        			st.pop();
        			st.push(cur);
        			cur=cur.right;
        		}
        	}
        	else{
        		if(cur.right!=null) st.push(cur.right);
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
    	 System.out.println(postorderTraversal(root));
    }
}
