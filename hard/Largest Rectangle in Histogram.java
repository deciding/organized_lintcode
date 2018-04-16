public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        int max=0;
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<=height.length;i++){
            int cur=0;
            if(i<height.length) cur=height[i];
            while(!st.isEmpty()&&cur<=height[st.peek()]){
                int h=height[st.pop()];
                int l;
                if(st.isEmpty()) l=-1;
                else l=st.peek();
                max=Math.max(h*(i-l-1),max);
            }
            st.push(i);
        }
        return max;
    }
}
