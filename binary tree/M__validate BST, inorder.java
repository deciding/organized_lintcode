import java.util.*;
// 1. resulttype:{isBST,max val, min val}
// 2. in order value check
 class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
         this.left = this.right = null;
      }
  }
 
// in order !!
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
	//conditions: 1. left , right isBST 2. in order value
	static int inOrderLastVal=Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // write your code here
    	if(root==null) return true;
    	if(!isValidBST(root.left)) return false;
    	if(root.val<=inOrderLastVal) return false;
    	inOrderLastVal=root.val;
    	return isValidBST(root.right);
    }
}
//below just in case first value is Integer.MIN_VALUE
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    static int inOrderLastVal=Integer.MIN_VALUE;
    static boolean startNode=true;
    public boolean isValidBST(TreeNode root) {
        // write your code here
      if(root==null) return true;
      if(!isValidBST(root.left)) return false;
      if(!startNode&&root.val<=inOrderLastVal) return false;
      startNode=false;
      inOrderLastVal=root.val;
      return isValidBST(root.right);
    }
}