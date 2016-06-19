import java.util.*;
public class Solution {
	public static int LSOne(int n){
		return n&(-n);
	}
	public static int countOnes(int n){
		int count=0;
		while(n!=0){// in case negative numbers, use !=0 not >0
			n-=LSOne(n);
			count++;
		}
		return count;
	}
	public static int bitSwapRequired(int a, int b) {
        // write your code here
		System.out.println(Integer.toBinaryString(a^b));
		return countOnes(a^b);
    }
	 
    public static void main(String args[]){
//    	Scanner sc=new Scanner(System.in);
//    	String a=sc.next();
    	System.out.println(bitSwapRequired(1,-1));
    	
//    	String b=sc.next();
//    	sc.close();
    }
}