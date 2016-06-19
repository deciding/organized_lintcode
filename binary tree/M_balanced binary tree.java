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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    //-1 means not balanced !!
    public int height(TreeNode node){
        if(node==null)return 0;
        else if(height(node.left)==-1||height(node.right)==-1)return -1;
        else return Math.abs(height(node.left)-height(node.right))<2?Math.max(height(node.left),height(node.right))+1:-1;
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return height(root)==-1?false:true;
    }
}