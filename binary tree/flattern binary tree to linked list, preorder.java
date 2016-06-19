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
// key !! preorder traversal
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    TreeNode node=new TreeNode(0);
    public void flatten(TreeNode root) {
        // write your code here
        if(root==null) return;
        node.right=root;
        node.left=null;
        node=node.right;
        
        TreeNode left=root.left,right=root.right;
        flatten(left);flatten(right);
    }
}