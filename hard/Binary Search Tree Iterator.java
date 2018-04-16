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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
   //2. morris traversal algorithm, O(1) space O(1) time worst case, 2n traversal I think
public class BSTIterator {
	TreeNode cur;
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
    	cur=root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
    	return cur!=null;
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
    	while(cur!=null){// can be while true, just in case 'no return' error
	    	if(cur.left==null){
	    		TreeNode ans= cur;
	    		cur=cur.right;
	    		return ans;
	    	}
	    	TreeNode prev=cur.left;
	    	while(prev.right!=null&&prev.right!=cur)// key !! two cases, one for link, one for revert back, the 2nd case means at start cur is just prev.right, link is not useful anymore
	    		prev=prev.right;
	    	if(prev.right==null){
	    		prev.right=cur;
	    		cur=cur.left;
	    	}
	    	else {
	    		TreeNode ans=prev.right;
	    		prev.right=null;//revert back
	    		cur=cur.right;//left part is finished
	    		return ans;
	    	}
    	}
    	return null;
    }
}
