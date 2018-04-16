public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    boolean isInt(String s){
        int len=s.length();
        for(int i=0;i<len;i++)
        if(!Character.isDigit(s.charAt(i))) return false;
        return true;
    }
    boolean isDecimal(String s){
        if(s.length()==0) return false;
        String[] strs=s.split("\\.");
        if(strs.length>2||strs.length==0) return false;
        
        if(strs[0].length()!=0&&(strs[0].charAt(0)=='+'||strs[0].charAt(0)=='-')) 
            strs[0]=strs[0].substring(1);
        for(int i=0;i<strs.length;i++)
        if(!isInt(strs[i])) return false;
        return true;
    }
    public boolean isNumber(String s) {
        // Write your code here
        if(s==null||s.length()==0) return false;
        int a=0,b=s.length()-1;
        while(a<s.length()&&s.charAt(a)==' ') a++;
        while(b>=0&&s.charAt(b)==' ') b--;
        if(a>b) return false;
        else s=s.substring(a,b+1);
        String[] strs=s.split("e");
        if(strs.length>2||strs.length==0) return false;
        for(int i=0;i<strs.length;i++)
        if(!isDecimal(strs[i])) return false;
        return true;
    }
}
