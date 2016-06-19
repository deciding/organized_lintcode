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
 
 
 
  class Solution {
	    /**
	     * This method will be invoked first, you should design your own algorithm 
	     * to serialize a binary tree which denote by a root node to a string which
	     * can be easily deserialized by your own "deserialize" method later.
	     */
	 
	    public static String serialize(TreeNode root) {
	        // write your code here
	        if(root==null) return "{}";
	        StringBuilder sb= new StringBuilder();
	        LinkedList<TreeNode> q= new LinkedList<TreeNode>();
	        q.add(root);

	        //key bloack !!
	        for(int i=0;i<q.size();i++){
	            TreeNode node=q.get(i);
	            if(node!=null) { q.add(node.left);q.add(node.right);}
	        }

	        while(q.getLast()==null) q.removeLast();
	        sb.append('{');
	        for(int i=0;i<q.size();i++)
	        if(q.get(i)==null)sb.append("#,");
	        else {sb.append(q.get(i).val);sb.append(',');}
	        sb.deleteCharAt(sb.length()-1);sb.append('}');
	        return sb.toString();
	    }
	    
	    /**
	     * This method will be invoked second, the argument data is what exactly
	     * you serialized at method "serialize", that means the data is not given by
	     * system, it's given by your own serialize method. So the format of data is
	     * designed by yourself, and deserialize it here as you serialize it in 
	     * "serialize" method.
	     */
	    public static TreeNode deserialize(String data) {
	        // write your code here
	        if(data.equals("{}")) return null;
	        TreeNode root= new TreeNode(0);
	        String[] vals=data.substring(1,data.length()-1).split(",");
	        LinkedList<TreeNode> q= new LinkedList<TreeNode>();

	        //key block !!
	        root.val=Integer.parseInt(vals[0]);
	        q.offer(root);
	        TreeNode node=root;
	        
	        boolean first=true;
	        for(int i=1;i<vals.length;i++){
	            if(first){
	            	first=false;
	                node=q.poll();
	                if(vals[i].equals("#")) node.left=null;
	                else {
	                    node.left=new TreeNode(0);
	                    node.left.val=Integer.parseInt(vals[i]);
	                    q.offer(node.left);
	                }
	            }
	            else {
	                first=true;
	                if(vals[i].equals("#")) node.right=null;
	                else {
	                    node.right=new TreeNode(0);
	                    node.right.val=Integer.parseInt(vals[i]);
	                    q.offer(node.right);
	                }
	            }
	        }
	        return root;
	    }
	    public static void main(String[] args){
	    	TreeNode root=new TreeNode(1);
	    	root.left=null;
	    	root.right=new TreeNode(2);
	    	
	    	String str=serialize(root);
	    	System.out.println(str);
	    	deserialize(str);
	    }
	}
