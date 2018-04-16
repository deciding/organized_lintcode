import java.util.*;
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        PriorityQueue<Integer> left=new PriorityQueue<Integer>(1,Collections.reverseOrder());
        PriorityQueue<Integer> right=new PriorityQueue<>();
        int[] median=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            left.offer(nums[i]);
            right.offer(left.poll());
            if(right.size()>left.size())
                left.offer(right.poll());
            median[i]=left.peek();
        }
        return median;
    }
}
