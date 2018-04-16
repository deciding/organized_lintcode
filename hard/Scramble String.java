public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if(s1==null||s2==null) return false;
        int n=s1.length();
        if(n!=s2.length()) return false;
        if(n==0) return true;
        if(n==1) return s1.charAt(0)==s2.charAt(0);
        boolean[][][] mem=new boolean[n][n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
        mem[i][j][0]=s1.charAt(i)==s2.charAt(j);
        for(int k=1;k<n;k++)
        for(int i=n-k-1;i>=0;i--)
        for(int j=n-k-1;j>=0;j--)
        for(int kk=0;kk<k;kk++)
        mem[i][j][k]|=mem[i][j][kk]&&mem[i+kk+1][j+kk+1][k-kk-1]||mem[i][j+k-kk][kk]&&mem[i+kk+1][j][k-kk-1];
        return mem[0][0][n-1];
    }
}
