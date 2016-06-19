package lintcode;
import java.util.*;
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
    	if(points==null||points.length==0) return 0;
    	if(points.length==1) return 1;
    	HashMap<Double,Integer> map=new HashMap<Double,Integer>();
    	double k=0.0;
    	int max=1;
    	for(int i=0;i<points.length;i++){
    		Point p=points[i];// key1 !! base point !
    		int dup=0;
    		map.clear();
    		for(int j=i+1;j<points.length;j++){
    			Point p1=points[j];
    			if(p.x==p1.x&&p.y==p1.y) {// key2 !! duplicates can be counted for every line
    			    dup++;
    			    continue;
    			}
    			k=p.x==p1.x?Integer.MAX_VALUE:((double)p.y-p1.y)/(p.x-p1.x);// key3 !! vertical line 
    			if(map.containsKey(k))
    				map.put(k, map.get(k)+1);
    			else map.put(k, 2);
    		}
    		for(double key:map.keySet())
    			max=Math.max(max, map.get(key)+dup);
    		if(map.size()==0) max=Math.max(max,1+dup);// key4 !! special case, all are the same points, actually we can use MIN_VAL
    	}
    	return max;
    }
}