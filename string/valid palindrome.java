package lintcode;
public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        int i=0;
        int j=s.length()-1;
        while(i<j)
            if(!Character.isLetterOrDigit(s.charAt(i)))i++;
            else if(!Character.isLetterOrDigit(s.charAt(j)))j--;
            else if(Character.toLowerCase(s.charAt(i++))!=Character.toLowerCase(s.charAt(j--)))
                return false;
        return true;
    }
}