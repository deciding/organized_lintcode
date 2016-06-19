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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
     LinkedList<TreeNode> q= new LinkedList<TreeNode>();
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root!=null) q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null) q.offer(cur.left);
            if(cur.right!=null) q.offer(cur.right);
            TreeNode temp=cur.left;
            cur.left=cur.right;
            cur.right=temp;
        }
    }
}
