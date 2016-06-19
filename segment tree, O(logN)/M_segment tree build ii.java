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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
	public SegmentTreeNode helper(int[] A, int start, int end){
		if(start>end) return null;
    	if(start==end) return new SegmentTreeNode(start,end,A[start]);
        SegmentTreeNode node=new SegmentTreeNode(start,end,0);
        int mid=(start+end)/2;
        SegmentTreeNode left= helper(A,start,mid);
        SegmentTreeNode right= helper(A,mid+1,end);
        node.left=left;
        node.right=right;
        node.max=Math.max(node.left.max, node.right.max);
        return node;
	}
    public SegmentTreeNode build(int[] A) {
        // write your code here
        return helper(A,0,A.length-1);
    }
}