import java.util.*;

public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
	//str.equals !!
    //path.split("/+") !!
    public static String simplifyPath(String path) {
        // Write your code here
    	String[] subs=path.split("/+"); // !! key
    	ArrayList<String> ps=new ArrayList<String>();
    	for(String sub:subs){
    		if(sub.equals("..")){
    			if(ps.size()>0) ps.remove(ps.size()-1);
    		}
    		else if(!sub.equals(".")&&!sub.equals("")) ps.add(sub);
    	}
    	if(ps.size()==0) return "/";
    	String ans="";
    	for(String str:ps)
    		ans+=("/"+str);
    	return ans;
    }
    public static void main(String[] args){
    	String str="/home//foo/";
    	System.out.println(simplifyPath(str));
    }
}