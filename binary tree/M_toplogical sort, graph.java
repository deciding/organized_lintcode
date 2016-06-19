import java.util.*;

  class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
  };
 
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */   
	public void dfs(DirectedGraphNode node, boolean[] visited, ArrayList<DirectedGraphNode> ans){
		visited[node.label]=true;
		for(DirectedGraphNode neighbor:node.neighbors)
			if(!visited[neighbor.label])
				dfs(neighbor,visited,ans);
		ans.add(node);// key !!
	}
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
    	ArrayList<DirectedGraphNode> ans= new ArrayList<DirectedGraphNode>();
    	boolean[] visited=new boolean[graph.size()];
    	for(int i=0;i<visited.length;i++)
    		visited[i]=false;
    	for(int i=0;i<graph.size();i++)
    		if(!visited[graph.get(i).label])
    			dfs(graph.get(i),visited,ans);
    	Collections.reverse(ans);// key !!
    	return ans;
    }
}