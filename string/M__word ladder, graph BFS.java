import java.util.*;
public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    // BFS with depth, same as unweighted shortest path !!
    // need record visited !!
    public static int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
    	if(start==null||start.length()==0) return 0;
    	HashSet<String> visited=new HashSet<String>();
    	Queue<String> q=new LinkedList<String>();
    	q.offer(start);
    	visited.add(start);
    	int depth=0;
    	while(!q.isEmpty()){
    		int size=q.size();//easier way for recording depth !!
    		depth++;
    		for(int index=0;index<size;index++){
	    		String cur=q.poll();
	    		if(cur.equals(end)) return depth;
	    		for(int i=0;i<cur.length();i++)
		    		for(char c='a';c<='z';c++)// faster !!
			    		if(cur.charAt(i)!=c){
			    			String part=cur.substring(0,i)+c+cur.substring(i+1);
			    			if(!visited.contains(part)&&dict.contains(part)){
			    				q.offer(part);
			    				visited.add(part);
			    			}
			    		}
    		}
    	}
    	return 0;
    }
    public static void main(String[] args){
    	HashSet<String> dict=new HashSet<String>();
    	dict.add("a");
    	dict.add("b");
    	dict.add("c");
    	System.out.println(ladderLength("a","c",dict));
    	
    }
}