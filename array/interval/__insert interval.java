/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list, must also sorted and merged
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
		if(intervals==null||newInterval==null) return intervals;
		ArrayList<Interval> ans = new ArrayList<Interval>();
		int pos=0;
		for(int i=0;i<intervals.size();i++){
			Interval intrvl=intervals.get(i);
			if(intrvl.end<newInterval.start){
				ans.add(intrvl);
				pos=i+1;// key !! record where to insert
			}
			else if(newInterval.end<intrvl.start)
				ans.add(intrvl);
			else {
				newInterval.start=Math.min(newInterval.start, intrvl.start);
				newInterval.end=Math.max(newInterval.end, intrvl.end);
			}
		}
		ans.add(pos,newInterval);
		return ans;
	}
}
