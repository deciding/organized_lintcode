import java.util.*;
public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
	public static void helper(ArrayList<String> list, String ans, String s, int k){
		if(s==null||s.length()==0) return;
		if(k==3){
			if(s.length()>1&&s.charAt(0)=='0') return;// !! special case: last one has trailing zero
			if(Integer.parseInt(s)<256) list.add(ans+s);
			return;
		}
		if(s.charAt(0)=='0'){
			helper(list,ans+"0.",s.substring(1, s.length()),k+1);// !! special case
			return;
		}
		for(int i=1;i<=s.length();i++){
			String candidate=s.substring(0, i);
			if(Integer.parseInt(candidate)>=256) break;// early pruning
			helper(list,ans+candidate+".",s.substring(i, s.length()),k+1);
		}
	}
    public static ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
    	ArrayList<String> ans= new ArrayList<String>();
    	helper(ans,"",s,0);
    	return ans;
    }
    public static void main(String[] args){
    	String s="1920000";
    	System.out.println(restoreIpAddresses(s));
    }
}