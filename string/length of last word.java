public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    // key !! count from last
    public int lengthOfLastWord(String s) {
        // Write your code here
        int ans=0;
        int i=s.length()-1;
        while(i>=0&&s.charAt(i)==' ') i--;
        if(i==-1) return 0;
        while(i>=0&&s.charAt(i)!=' '){
            i--;
            ans++;
        }
        return ans;
    }
}
