public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    // key !! same as find element in rotated sorted array, since duplicates exist, we can only reach O(N) 
    public int findMin(int[] num){
        // write your code here
        int min=num[0];
        for(int i=1;i<num.length;i++)
        if(num[i]<min) min=num[i];
        return min;
    }
}