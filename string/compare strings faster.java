import java.util.*;
public class Solution {
	public static boolean compareStrings(String A, String B) {
        // write your code here
		StringBuilder AA=new StringBuilder(A);
		for(int i=0;i<B.length();i++){
			int index=AA.indexOf(""+B.charAt(i));
			if(index==-1)
				return false;
			AA.setCharAt(index,'a');
		}
		return true;
    }
	
    public static void main(String args[]){
    	Scanner sc=new Scanner(System.in);
    	String a=sc.next();
    	String b=sc.next();
    	System.out.println(compareStrings(a,b));
    	sc.close();
    }
}