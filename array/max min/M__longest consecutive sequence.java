public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    // key !! dynamic removing-> O(N)
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> hs=new HashSet<Integer>();
        int max=0;
        int len=0;
        for(int i:num)
        hs.add(i);
        for(int i:num){
            len=0;
            int key=i;
            while(hs.contains(key)){
                len++;
                max=Math.max(max,len);
                hs.remove(key);
                key++;
            }
            key=i-1;
            while(hs.contains(key)){
                len++;
                max=Math.max(max,len);
                hs.remove(key);
                key--;
            }
        }
        return max;
    }
}