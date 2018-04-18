/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //store global not local, so we can just keep 2 levels of prev, instead of 3 levels
    //no need hashmap, just 2 level 4 vars:ll/lr/rl/rr
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    HashMap<TreeNode,Integer> mem=new HashMap<>();
    int helper(TreeNode cur){
        if(cur==null) return 0;
        if(mem.containsKey(cur)) return mem.get(cur);
        int ans1=helper(cur.left)+helper(cur.right);
        int ans2=cur.val;
        if(cur.left!=null)
        ans2+=helper(cur.left.left)+helper(cur.left.right);
        if(cur.right!=null)
        ans2+=helper(cur.right.left)+helper(cur.right.right);
        mem.put(cur,Math.max(ans1,ans2));
        return Math.max(ans1,ans2);
    }
    public int houseRobber3(TreeNode root) {
        // write your code here
        return helper(root);
    }
}
