package lintcode;
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int[] count= new int [256];
        for(int i=0;i<s.length();i++){
            count[(int)s.charAt(i)]++;
            count[(int)t.charAt(i)]--;// key !!
        }
        for(int i=0;i<256;i++)
            if(count[i]!=0)
                return false;
        return true;
    }
};