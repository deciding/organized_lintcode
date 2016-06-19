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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public void dfs(ArrayList<String> ans, String path, TreeNode node){
        if(node==null) return;
        if(node.left!=null) dfs(ans,path+node.val+"->",node.left);
        if(node.right!=null) dfs(ans,path+node.val+"->",node.right);
        if(node.left==null&&node.right==null) ans.add(path+node.val);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        ArrayList<String> ans=new ArrayList<String>();
        dfs(ans,"",root);
        return ans;
    }
}