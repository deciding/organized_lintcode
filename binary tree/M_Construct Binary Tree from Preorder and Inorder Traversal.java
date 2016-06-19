package lintcode;
import java.util.*;

  //Definition of TreeNode:
  class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
 
 
// find i,j !!
public class Solution {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
	public TreeNode buildSubtree(int[] inorder,int ai, int bi, int[] preorder,int ap, int bp){
        if(ai>bi||ap>bp)return null;
        TreeNode node=new TreeNode(preorder[ap]);
        int i;
        for(i=ai;i<=bi;i++)
        if(inorder[i]==preorder[ap]) break;
        int j=ap+1+(i-ai);
        node.left=buildSubtree(inorder,ai,i-1,preorder,ap+1,j-1);
        node.right=buildSubtree(inorder,i+1,bi,preorder,j,bp);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        return buildSubtree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }
}