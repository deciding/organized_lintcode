package lintcode;
import java.util.*;


  //Definition of TreeNode:
	class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
 
 
 
	public class Solution {
	    /**
	     * @param root: The root of binary tree.
	     * @return: A list of lists of integer include 
	     *          the zigzag level order traversal of its nodes' values 
	     */
	    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        // write your code here
	        Stack<TreeNode> S1=new Stack<TreeNode>();
	        Stack<TreeNode> S2=new Stack<TreeNode>();
	        Stack<TreeNode> tmp;
	        ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	        if(root==null) return ans;
	        boolean zignzag=true;
	        S1.push(root);
	        while(!S1.isEmpty()){
	            ArrayList<Integer> lvl= new ArrayList<Integer>();
	            while(!S1.isEmpty()){
	                TreeNode node=S1.pop();
	                lvl.add(node.val);
	                if(zignzag){
	                    if(node.left!=null) S2.push(node.left);
	                    if(node.right!=null) S2.push(node.right);
	                }
	                else {// normal order !!
	                    if(node.right!=null) S2.push(node.right);
	                    if(node.left!=null) S2.push(node.left);
	                }
	            }
	            ans.add(lvl);
	            tmp=S1;
	            S1=S2;
	            S2=tmp;
	            zignzag=!zignzag;
	        }
	        return ans;
	    }
	}