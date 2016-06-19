package lintcode;
public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        int[] count= new int[256];// key !! hash
        for(int i=0;i<str.length();i++){
            count[(int)str.charAt(i)]++;
            if(count[(int)str.charAt(i)]>1) return false;
        }
        return true;
    }
}

//no other data structure
public boolean uniqueChars(String s) {
    int checker = 0;
    for (int i = 0; i < s.length(); i++) {
        int cur = s.charAt(i) - 'a';
        if ((checker & (1 << cur)) > 0) {
            return false;
        }
        checker |= 1 << cur;
    }
    return true;
    }