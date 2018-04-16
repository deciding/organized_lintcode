public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    void ladderLength(String start, String end, Set<String> dict, HashMap<String,Integer> level) {
        // write your code here
    	if(start==null||start.length()==0) return;
    	Queue<String> q=new LinkedList<String>();
    	int depth=0;
    	q.offer(start);
	    level.put(start,depth);
    	while(!q.isEmpty()){
    		int size=q.size();//easier way for recording depth !!
    		depth++;
    		for(int index=0;index<size;index++){
	    		String cur=q.poll();
			    if(cur.equals(end)) return;
	    		for(int i=0;i<cur.length();i++)
		    		for(char c='a';c<='z';c++)
			    		if(cur.charAt(i)!=c){
			    			String part=cur.substring(0,i)+c+cur.substring(i+1);
			    			if(!level.containsKey(part)&&(dict.contains(part)||part.equals(end))){
			    				q.offer(part);
	    		                level.put(part,depth);
			    			}
			    		}
    		}
    	}
    }
    void dfs(String cur, String end, Set<String> dict, HashMap<String,Integer> level, LinkedList<String> oneAns, ArrayList<List<String>> allAns){
        if(!level.containsKey(cur)) return;
        oneAns.add(cur);
        if(cur.equals(end)){
            LinkedList<String> newOneAns=new LinkedList<String>(oneAns);
            allAns.add(newOneAns);
            oneAns.removeLast();
            return;
        }
        int d=level.get(cur);
        for(int i=0;i<cur.length();i++)
    		for(char c='a';c<='z';c++)
	    		if(cur.charAt(i)!=c){
	    		    String part=cur.substring(0,i)+c+cur.substring(i+1);
	    		    if(level.containsKey(part)&&level.get(part)==d+1)
	    		        dfs(part,end,dict,level,oneAns,allAns);
	    		}
	    oneAns.removeLast();
    }
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        ArrayList<List<String>> ans=new ArrayList<List<String>>();
        LinkedList<String> oneAns=new LinkedList<String>();
        HashMap<String,Integer> level=new HashMap<>();
        ladderLength(start,end,dict,level);
        dfs(start,end,dict,level,oneAns,ans);
        return ans;
    }
}
