package lintcode;

 //Definition of TreeNode:
 public class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
    }
 }

public class Solution {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2==null) return true;
        if(T1==null) return false;
        if(T1.val==T2.val&&isSame(T1,T2)) return true;
        return isSubtree(T1.left,T2)||isSubtree(T1.right,T2);
    }
    public boolean isSame(TreeNode T1, TreeNode T2){
        if(T1==null&&T2==null) return true;
        if(T1!=null&&T2!=null&&T1.val==T2.val) 
            return isSame(T1.left,T2.left)&&isSame(T1.right,T2.right);
        return false;
    }
}