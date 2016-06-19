/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
	        // write your code here
	    	if(root==null) return -1;
	    	int l=root.start;
	    	int r=root.end;
	    	if(start<=l&&r<=end) return root.max;
	    	if(r<start||end<l) return -1;
	    	int res1=query(root.left,start,end);
	    	int res2=query(root.right,start,end);
	    	return Math.max(res1, res2);
	    }
}