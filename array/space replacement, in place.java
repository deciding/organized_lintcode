package lintcode;
public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    // key !! first calculate new length, to do replacement in place, start from back, use 2 pointers
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        int newlen=length;
        for(int i=0;i<length;i++)
            if(string[i]==' ') newlen+=2;
        int index=newlen-1;
        for(int i=length-1;i>=0;i--)
            if(string[i]==' '){
                string[index--]='0';
                string[index--]='2';
                string[index--]='%';
            }
            else string[index--]=string[i];
        return newlen;  
    }
}