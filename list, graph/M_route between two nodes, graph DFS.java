import java.util.*;

  class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<DirectedGraphNode>();
      }
  };
 
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
	public static boolean helper(HashMap<Integer,Boolean> visited, DirectedGraphNode node, DirectedGraphNode t){
		ArrayList<DirectedGraphNode> neighbors=node.neighbors;
		for(int i=0;i<neighbors.size();i++)
			if(!visited.get(neighbors.get(i).label)){
				if(neighbors.get(i).label==t.label) return true;
				visited.put(neighbors.get(i).label, true);
				if(helper(visited,neighbors.get(i),t)) return true;
			}
		return false;
	}
    public static boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
    	if(s==null||t==null) return false;
    	if(s.label==t.label) return true;
    	HashMap<Integer,Boolean> visited= new HashMap<Integer,Boolean>();
    	for(int i=0;i<graph.size();i++)
    		visited.put(graph.get(i).label, false);
    	return helper(visited,s,t);
    }
    public static void main(String[] args){
    	ArrayList<DirectedGraphNode> graph= new ArrayList<DirectedGraphNode>();
    	DirectedGraphNode a=new DirectedGraphNode(3);
    	DirectedGraphNode b=new DirectedGraphNode(1);
    	a.neighbors.add(b);
    	graph.add(a);
    	graph.add(b);
    	System.out.println(hasRoute(graph,a,b));
    }
}