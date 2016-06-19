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
    public TreeNode buildSubtree(int[] inorder,int ai, int bi, int[] postorder,int ap, int bp){
        if(ai>bi||ap>bp)return null;
        TreeNode node=new TreeNode(postorder[bp]);
        int i;
        for(i=ai;i<=bi;i++)
        if(inorder[i]==postorder[bp]) break;
        int j=ap+(i-ai);
        node.left=buildSubtree(inorder,ai,i-1,postorder,ap,j-1);
        node.right=buildSubtree(inorder,i+1,bi,postorder,j,bp-1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        return buildSubtree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
}