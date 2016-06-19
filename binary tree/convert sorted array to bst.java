//you cannot change what the pointer param points to
//so you need to return what it should point to, and reassign in the upper level function
import java.util.*;
public class Solution {
	  public static class TreeNode {
	      public int val;
	      public TreeNode left, right;
	      public TreeNode(int val) {
	          this.val = val;
	          this.left = this.right = null;
	      }
	  }
	  // key !! use left, right, this is easier than list, because we can get mid value immediately
	  public static TreeNode addNode(TreeNode node, int[]A, int left, int right){
		  if(left>right)return null;
		  int mid= (left+right)/2;
		  node=new TreeNode(A[mid]);
		  node.left=addNode(node.left,A,left,mid-1);
		  node.right=addNode(node.left,A,mid+1,right);
		  return node;
	  }
	public static TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
		TreeNode root= null;
		root=addNode(root,A,0,A.length-1);
		return root;
    }
	public static void inorder(TreeNode node){
		if(node==null) return;
		if(node.left!=null) inorder(node.left);
		System.out.println(node.val);
		if(node.right!=null) inorder(node.right);
	}
    public static void main(String args[]){
//    	Scanner sc=new Scanner(System.in);
//    	String a=sc.next();
//    	String b=sc.next();
    	int[] A={1,2,3,4,5,6,7};
    	TreeNode root=sortedArrayToBST(A);
    	inorder(root);
    	
//    	sc.close();
    }
}