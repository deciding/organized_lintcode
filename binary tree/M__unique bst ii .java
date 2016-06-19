import java.util.*;

  class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }
// key !! based on the understanding of the catalan number
public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
	public static ArrayList<TreeNode> helper(int i, int j){
		ArrayList<TreeNode> ans= new ArrayList<TreeNode>();
		if(i>j) {
			ans.add(null);
			return ans;
		}
		for(int index=i;index<=j;index++){
			ArrayList<TreeNode> left=helper(i,index-1);
			ArrayList<TreeNode> right=helper(index+1,j);
			for(TreeNode l:left)
				for(TreeNode r:right){
					TreeNode root=new TreeNode(index);
					root.left=l;
					root.right=r;
					ans.add(root);
				}
		}
		return ans;
	}
    public static List<TreeNode> generateTrees(int n) {
        // write your code here
    	return helper(1,n);
    }
}