package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    // key !! liangtoujia, if move the higher edge, it can only make the area smaller !!
    public int maxArea(int[] heights) {
        // write your code here
        int l=0,r=heights.length-1,ans=0;
        while(l<r){
            ans=Math.max(ans,Math.min(heights[l],heights[r])*(r-l));
            int dummy=heights[l]>heights[r]?r--:l++;
        }
        return ans;
    }
}