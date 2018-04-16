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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode merge(TreeNode l, TreeNode r){
        if(l.right==null){
            l.right=r;
            return l;
        }
        if(r.left==null){
            r.left=l;
            return r;
        }
        l.right=merge(l.right,r);
        return l;
    }
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root==null) return root;
        if(root.val==value){
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            return merge(root.left,root.right);
        }
        if(root.val<value) root.right=removeNode(root.right,value);
        else root.left=removeNode(root.left,value);
        return root;
    }
}
