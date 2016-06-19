import java.util.*;
public class Solution {
//	  public static class TreeNode {
//	      public int val;
//	      public TreeNode left, right;
//	      public TreeNode(int val) {
//	          this.val = val;
//	          this.left = this.right = null;
//	      }
//	  }
	public static double cosineSimilarity(int[] A, int[] B) {
        // write your code here
		int AB=0, AA=0,BB=0;
		for(int i=0;i<A.length;i++){
			AB+=A[i]*B[i];
			AA+=A[i]*A[i];
			BB+=B[i]*B[i];
		}
		if(AA==0||BB==0)
			return 2.0;
		// key !! formula
		return AB/Math.sqrt(AA)/Math.sqrt(BB);// !! in case overflow
    }
    public static void main(String args[]){
//    	Scanner sc=new Scanner(System.in);
//    	String a=sc.next();
//    	String b=sc.next();
    	int[] A= {1000,2000,3000};
    	int[] B= {2000,3000,4000};
    	System.out.println(cosineSimilarity(A,B));
//    	sc.close();
    }
}