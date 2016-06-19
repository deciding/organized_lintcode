package lintcode;
import java.util.*;
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// key !! 2 methods:
// 1. traverse original-> map old-new -> new may already exist in map, link may already exist in map, link while create
// 2. traverse original-> map old-new -> all old nodes in a new array -> traverse new array to link
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node==null) return node;
        ArrayList<UndirectedGraphNode> nodes= new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map= new HashMap<>();
        nodes.add(node);
        map.put(node,new UndirectedGraphNode(node.label));
        int visited=0;
        //all nodes
        // key !! simplified BFS
        while(visited<nodes.size()){
            UndirectedGraphNode cur=nodes.get(visited++);
            for(UndirectedGraphNode neighbor:cur.neighbors)
            if(!map.containsKey(neighbor)){
                map.put(neighbor,new UndirectedGraphNode(neighbor.label));
                nodes.add(neighbor);
            }
        }
        //all neighbors
        for(UndirectedGraphNode cur: nodes)
        for(UndirectedGraphNode neighbor:cur.neighbors)
        map.get(cur).neighbors.add(map.get(neighbor));
        return map.get(node);
    }
}