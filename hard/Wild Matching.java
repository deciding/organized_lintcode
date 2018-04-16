public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    int[][] mem;
    boolean canBeEmpty(String p){
        if(p.length()==0) return true;
        for(int i=0;i<p.length();i++)
        if(p.charAt(i)!='*') return false;
        return true;
    }
    public boolean match(String s, String p) {
        // write your code here
        if(s==null||p==null) return false;
        if(p.length()==0&&s.length()!=0) return false;
        if(mem[s.length()][p.length()]!=0) return mem[s.length()][p.length()]==1;
        boolean ans=false;
        if(s.length()==0) ans=canBeEmpty(p);
        else if(p.charAt(0)=='?'||p.charAt(0)==s.charAt(0)) ans=match(s.substring(1),p.substring(1));
        else if(p.charAt(0)=='*') ans= match(s.substring(1),p)||match(s.substring(1),p.substring(1));
        mem[s.length()][p.length()]=ans?1:2;
        return ans;
     }
     public boolean isMatch(String s, String p) {
        // write your code here
        mem= new int[s.length()+1][p.length()+1];
        return match(s,p);
     }
}
