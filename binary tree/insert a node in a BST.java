//can never change where does a pointer point to by using it's copy
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
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        TreeNode cur=root;
        if(root==null){
            return node;
        }
        while(cur!=null){
            if(cur.val>=node.val){
                if(cur.left==null){
                    cur.left=node;
                    break;
                }
                cur=cur.left;
            }
            else{
                if(cur.right==null){
                    cur.right=node;
                    break;
                }
                cur=cur.right;
            }
        }
        return root;
    }
}
