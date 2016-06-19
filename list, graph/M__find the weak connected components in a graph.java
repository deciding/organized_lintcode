package lintcode;
import java.util.*;
//strong as well as weak
//key !! we cannot use the HashMap only method anymore, for weak edges,
//instead we must use union find

  //Definition for Directed graph.
  class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
  };
  class UnionFind{
		private HashMap<Integer,Integer> p,rank,setSize;
		private int setNum;
		public UnionFind(int[] N){
			p=new HashMap<Integer,Integer>();rank=new HashMap<Integer,Integer>();setSize=new HashMap<Integer,Integer>();
			for(int i=0;i<N.length;i++){
				p.put(N[i],N[i]);rank.put(N[i],0);setSize.put(N[i],1);
			}
			setNum=N.length;
		}
		public int findSet(int n){
			if(p.get(n)==n) return n;
			int ans= findSet(p.get(n));
			p.put(n, ans);
			return ans;
		}
		public boolean isSameSet(int i, int j){
			return findSet(i)==findSet(j);
		}
		public void unionSet(int i, int j){
			int x=findSet(i);
			int y=findSet(j);
			if(x==y) return;
			setNum--;
			if(rank.get(x)>rank.get(y)){
				p.put(y, x);
				setSize.put(x, setSize.get(x)+setSize.get(y));
			}
			else {
				p.put(x, y);
				setSize.put(y, setSize.get(x)+setSize.get(y));
				if(rank.get(x)==rank.get(y))
					rank.put(y, rank.get(y)+1);
			}
		}
		public int numOfSets(){
			return setNum;
		}
		public int sizeOfSet(int i){
			return setSize.get(findSet(i));
		}
	}
 
public class Solution {
	
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public static List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
    	int[] N=new int[nodes.size()];
    	for(int i=0;i<N.length;i++)
    		N[i]=nodes.get(i).label;// key !! the labels may not be continuous, thus we use int[] to initial UF
    	UnionFind UF=new UnionFind(N);
    	ArrayList<List<Integer>> ans=new ArrayList<List<Integer>>();

    	for(DirectedGraphNode node:nodes)
    	for(DirectedGraphNode neighbor:node.neighbors)
    		UF.unionSet(node.label, neighbor.label);

    	HashMap<Integer,Integer> labelToPos=new HashMap<Integer,Integer>();
    	for(DirectedGraphNode node:nodes){
    		int root=UF.findSet(node.label);
    		if(!labelToPos.containsKey(root)) {
    			ans.add(new ArrayList<Integer>());
    			labelToPos.put(root,ans.size()-1);
    		}
    		int pos=labelToPos.get(root);
    		ans.get(pos).add(node.label);
    	}

    	for(List<Integer> item:ans)
    		Collections.sort(item);
    	return ans;
    }
    public static void main(String[] args){
    	ArrayList<DirectedGraphNode> nodes=new ArrayList<DirectedGraphNode>();
    	nodes.add(new DirectedGraphNode(1));
    	nodes.add(new DirectedGraphNode(2));
    	nodes.add(new DirectedGraphNode(3));
    	nodes.add(new DirectedGraphNode(4));
    	nodes.add(new DirectedGraphNode(1));
    	nodes.add(new DirectedGraphNode(1));
    }
}