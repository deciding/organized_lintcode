public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str==null||str.length()==0) return 0;
        int a=0;
        while(str.charAt(a)==' ') a++;
        if(a==str.length()) return 0;
        int b=str.length()-1;
        while(str.charAt(b)==' ') b--;
        if(b==-1) return 0;
        str=str.substring(a,b+1);
        boolean neg=false;
        if(str.charAt(0)=='-'||str.charAt(0)=='+') {
            neg=str.charAt(0)=='-';
            str=str.substring(1);
            if(str.length()==0||!Character.isDigit(str.charAt(0))) return 0;
        }
        String[] strs=str.split("\\.");
        if(strs.length>2) return 0;
        str=strs[0];
        long ans=0;
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))) break;
            int cur=str.charAt(i)-'0';
            ans=cur+ans*10;
            if(neg&&ans-1>=Integer.MAX_VALUE) return Integer.MIN_VALUE;
            if(!neg&&ans>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        int ans1=0;
        int bit=1;
        for(int i=0;i<32;i++){
            if((ans&bit)!=0) ans1|=bit;
            bit<<=1;
        }
        return neg?-ans1:ans1;
    }
}
