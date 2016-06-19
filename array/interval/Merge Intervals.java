//Greedy
//using Comparator
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if(intervals.size()==0) return new ArrayList<Interval>();
        Comparator<Interval> comp = new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                if(a.start==b.start)
                    return a.end-b.end;
               return a.start-b.start;
            }
        };
        Collections.sort(intervals,comp);
        ArrayList<Interval> result= new  ArrayList<Interval>();
        result.add(intervals.get(0));// optional !! put one inside first, diff from insert interval
        
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start<=result.get(result.size()-1).end)
                result.get(result.size()-1).end= Math.max(result.get(result.size()-1).end,intervals.get(i).end);
            else result.add(intervals.get(i));
        }
        return result;
    }

}
