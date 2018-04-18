public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if(s.length()==0||s.charAt(0)=='0') return 0;
        int pp=1,p=1,cur=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'&&s.charAt(i-1)!='1'&&s.charAt(i-1)!='2') return 0;
            if(s.charAt(i)=='0') cur=pp;
            else if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<'7')
                cur=p+pp;
            else cur=p;
            pp=p;p=cur;
        }
        return cur;
    }
}
