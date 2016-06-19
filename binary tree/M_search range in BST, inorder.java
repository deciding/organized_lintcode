import java.util.*;

  class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
 
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
  // inorder !! simpilify !!
	public void helper(ArrayList<Integer> ans, TreeNode node, int k1, int k2){
		if(node==null) return;
		if(node.val>k1) helper(ans,node.left,k1,k2);
		if(node.val>=k1&&node.val<=k2) ans.add(node.val);
		if(node.val<k2) helper(ans,node.right,k1,k2);
	}
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
    	ArrayList<Integer> ans= new ArrayList<Integer>();
    	helper(ans,root,k1,k2);
    	return ans;
    }
}