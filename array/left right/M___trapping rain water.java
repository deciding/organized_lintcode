import java.util.*;
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
	//2 methods
	//1. max-> left ->right
	//2. every element, left max, right max
	
	//1.
//    public static int trapRainWater(int[] heights) {
//        // write your code here
//    	int maxHeight=0, maxIndex=0;
//    	int area=0;
//    	//findMax()
//    	for(int i=0;i<heights.length;i++)
//    		if(heights[i]>maxHeight){
//    			maxHeight=heights[i];
//    			maxIndex=i;
//    		}
//    	//left area
//    	int leftMax=0;
//    	for(int i=0;i<maxIndex;i++){
//    		if(heights[i]>leftMax){
//    			area+=(heights[i]-leftMax)*(maxIndex-i);
//    			leftMax=heights[i];
//    		}
//    		area-=heights[i];
//    	}
//    	//right area
//    	int rightMax=0;
//    	for(int i=heights.length-1;i>maxIndex;i--){
//    		if(heights[i]>rightMax){
//    			area+=(heights[i]-rightMax)*(i-maxIndex);
//    			rightMax=heights[i];
//    		}
//    		area-=heights[i];
//    	}
//    	return area;
//    }
	//2.
	public static int trapRainWater(int[] heights) {
		int area=0;
		int[] leftMax=new int[heights.length];
		for(int i=1;i<heights.length;i++)
			leftMax[i]=Math.max(leftMax[i-1],heights[i-1]);
		int rightMax=0;
		for(int i=heights.length-1;i>=0;i--){
			area+=Math.min(leftMax[i], rightMax)>heights[i]?Math.min(leftMax[i], rightMax)-heights[i]:0;
			rightMax=Math.max(rightMax,heights[i]);
		}
		return area;
	}
    public static void main(String[] args){
    	System.out.println(trapRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}