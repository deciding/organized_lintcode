import java.util.*;

public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public static int romanToInt(String s) {
        // Write your code here
    	if(s==null||s.length()==0) return 0;
    	HashMap<Character,Integer> hm= new HashMap<Character,Integer>();// hashmap is more suitable here
    	hm.put('I', 1);
    	hm.put('V', 5);
    	hm.put('X',10);
    	hm.put('L', 50);
    	hm.put('C', 100);
    	hm.put('D', 500);
    	hm.put('M', 1000);
    	int ans=0;
        // key !!
    	for(int i=s.length()-1;i>=0;i--){
    		int num=hm.get(s.charAt(i));
    		int num2=i==s.length()-1?0:hm.get(s.charAt(i+1));
    		if(num>=num2) ans+=num;
    		else ans-=num;
    	}
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(romanToInt("DXCIII"));
    }
}