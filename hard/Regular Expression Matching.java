public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean canBeEmpty(String p){
        int len=p.length();
        if(len==0||len%2==1) return false;
        for(int i=1;i<len;i+=2)
        if(p.charAt(i)!='*') return false;
        return true;
    }
    public boolean isMatch(String s, String p) {
        // write your code here
        if(p.length()==0) return s.length()==0;
        if(s.length()==0) return canBeEmpty(p);
        if(p.length()==1||p.charAt(1)!='*'){
            if(p.charAt(0)=='.'||p.charAt(0)==s.charAt(0))
                return isMatch(s.substring(1),p.substring(1));
            return false;
        }
        boolean ans=isMatch(s,p.substring(2));
        if(p.charAt(0)=='.'||p.charAt(0)==s.charAt(0))
            ans|=isMatch(s.substring(1),p);
        return ans;
    }
}
