import java.util.*;

class SegmentTreeNode {
	      public int start, end, count;
	      public SegmentTreeNode left, right;
	      public SegmentTreeNode(int start, int end, int count) {
	          this.start = start;
	          this.end = end;
	          this.count = count;
	          this.left = this.right = null;
	      }
	  }
	 
 
  public class Solution {
	    /**
	     *@param root, start, end: The root of segment tree and 
	     *                         an segment / interval
	     *@return: The maximum number in the interval [start, end]
	     */
	    public int query(SegmentTreeNode root, int start, int end) {
	        // write your code here
	    	if(root==null) return 0;
	    	int l=root.start;
	    	int r=root.end;
	    	if(start<=l&&r<=end) return root.count;
	    	if(r<start||end<l) return 0;
	    	int res1=query(root.left,start,end);
	    	int res2=query(root.right,start,end);
	    	return res1+res2;
	    }
	}