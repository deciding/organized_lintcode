package lintcode;
import java.util.*;

public class Solution {
    /**
     * @param digits A digital string
     * @return all possible letter combinations
     */
	public static String[][] letters=new String[][]{{},{},{"a","b","c"},{"d","e","f"},
		{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},
		{"w","x","y","z"}};
	public static void combine(String str,ArrayList<String> ans, String digits){
		if(digits.length()==0){
			ans.add(str);
			return;
		}
		int index=Integer.parseInt(digits.substring(0,1));
		String[] str_list=letters[index];
		for(int j=0;j<str_list.length;j++)
			combine(str+str_list[j],ans,digits.substring(1,digits.length()));
	}
    public static ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        String str="";
        ArrayList<String> ans=new ArrayList<String>();
        if(digits=="") return ans;
        combine(str,ans,digits);
        return ans;
    }
    public static void main(String[] args){
    	System.out.println(letterCombinations("23"));
    }
}