package lintcode;
import java.util.*;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
     //D&C !
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root==A||root==B||root==null) return root;//can only get node1,node2,null
        TreeNode l=lowestCommonAncestor(root.left, A, B);
        TreeNode r=lowestCommonAncestor(root.right, A, B);
        if(l!=null&&r!=null) return root;//LCA
        return l==null?r:l;
    }
}