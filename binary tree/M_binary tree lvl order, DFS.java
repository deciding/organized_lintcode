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
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
    public void dfs(int d, TreeNode node){
        if(node==null) return;
        if(ans.size()-1<d){
            ArrayList<Integer> temp= new ArrayList<Integer>();
            ans.add(temp);
        }
        ans.get(d).add(node.val);
        dfs(d+1,node.left);
        dfs(d+1,node.right);
    }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        dfs(0,root);
        return ans;
    }
}