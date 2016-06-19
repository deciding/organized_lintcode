package lintcode;
import java.util.*;
// same as ()(((())()()))) altogether how deep are the deepest parentheses !!
   class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
   }
 
// key !! think of brackets, at most how many brackets are not closed in the same time
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
	class Bracket{
		int val;
		boolean flag;
		Bracket(int val, boolean flag){
			this.val=val;
			this.flag=flag;
		}
	}
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
    	if(airplanes.size()==0) return 0;
    	Comparator<Bracket> cmp=new Comparator<Bracket>(){
    		public int compare(Bracket a,Bracket b){
    			return a.val!=b.val?a.val-b.val:(a.flag?1:-1);
    		}
    	};
    	ArrayList<Bracket> brackets= new ArrayList<Bracket>();
    	for(int i=0;i<airplanes.size();i++){
    		brackets.add(new Bracket(airplanes.get(i).start,true));
    		brackets.add(new Bracket(airplanes.get(i).end,false));
    	}
    	Collections.sort(brackets,cmp);
    	int cnt=0,max=0;
    	for(int i=0;i<brackets.size();i++){
    		if(brackets.get(i).flag) cnt++;
    		else cnt--;
    		max=Math.max(max, cnt);
    	}
    	return max;
    }
    
}