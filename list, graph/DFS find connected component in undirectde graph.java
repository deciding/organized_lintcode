import java.util.*;
public class Solution {
 public static class UndirectedGraphNode {
	      int label;
	      ArrayList<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };
   public static HashSet visited= new HashSet();
   public static ArrayList<List<Integer>> result= new ArrayList<List<Integer>>();
   public static void DFS(UndirectedGraphNode node){
	   visited.add(node.label);
	   result.get(result.size()-1).add(node.label);
	   for(int i=0;i<node.neighbors.size();i++)if(!visited.contains(node.neighbors.get(i).label)){
		   DFS(node.neighbors.get(i));
	   }
   }
  public static List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
	  	for(int i=0;i<nodes.size();i++)if(!visited.contains(nodes.get(i).label)){
	  		result.add(new ArrayList<Integer>());
	  		DFS(nodes.get(i));
	  		Collections.sort(result.get(result.size()-1));
	  	}
        return result;
    }
	 
    public static void main(String args[]){
//    	Scanner sc=new Scanner(System.in);
//    	String a=sc.next();
//    	String b=sc.next();
//    	sc.close();
    }
}