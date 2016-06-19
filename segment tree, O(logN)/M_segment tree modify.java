import java.util.*;

  class SegmentTreeNode {
      public int start, end, max;
      public SegmentTreeNode left, right;
      public SegmentTreeNode(int start, int end, int max) {
          this.start = start;
          this.end = end;
          this.max = max;
          this.left = this.right = null;
      }
  }
 
public class Solution {
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
	public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
    	if(root==null) return;
		int a=root.start;
		int b=root.end;
		if(a==b){
		    if(a==index) root.max=value;
		    return;
		}
		int mid=(a+b)/2;
		if(index<=mid) modify(root.left,index,value);
		else modify(root.right,index,value);
		root.max=Math.max(root.left.max, root.right.max);
    }
}