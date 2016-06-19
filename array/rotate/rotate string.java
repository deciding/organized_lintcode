public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void reverse(char[] str, int m, int n){
        while(m<n){
            char temp=str[m];
            str[m]=str[n];
            str[n]=temp;
            m++;
            n--;
        }
    } 
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str.length==0) return;
        int l_offset=str.length-offset%str.length;
        // the three lines is to rotate from right to left
        reverse(str,0,l_offset-1);
        reverse(str,l_offset,str.length-1);
        reverse(str,0,str.length-1);
    }
}