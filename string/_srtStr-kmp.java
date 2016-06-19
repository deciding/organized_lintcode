package lintcode;
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source==null||target==null) return -1;
        if(target=="")return 0;
        int n=source.length();
        int m=target.length();
        int[] b = new int[m+1];// !! the previous suffix which has same prefix
        b[0]=-1;
        int i=0,j=-1;
        while(i<m){
            while(j>=0&&target.charAt(i)!=target.charAt(j))j=b[j];
            i++;j++;
            b[i]=j;
        }
        i=0;j=0;
        while(i<n){
            while(j>=0&&source.charAt(i)!=target.charAt(j))j=b[j];
            i++;j++;
            if(j==m){// 1 after the last char in target
                //j=b[j] if you want to search all
                return i-m;
            }
        }
        return -1;
    }
}