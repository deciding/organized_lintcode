import java.util.*;
// hash !!
public class Solution {
	public static boolean compareStrings(String A, String B) {
        // write your code here
		int[] AA=new int[26];
		for(int i=0;i<A.length();i++){
			AA[A.charAt(i)-'A']++;
		}
		for(int i=0;i<B.length();i++){
			if(--AA[B.charAt(i)-'A']<0) return false;// key !!
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