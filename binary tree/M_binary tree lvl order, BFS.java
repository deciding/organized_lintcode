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
 
 // 3 methods: 1. queue size, 2. 2 stack, 3.  dfs(int depth, TreeNode node), but the processing order is not good
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int k=q.size();
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<k;i++){
            TreeNode node=q.poll();
            temp.add(node.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}