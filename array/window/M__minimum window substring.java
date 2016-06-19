package lintcode;
import java.util.*;
// !! we need a hash to see whether all chars contained in the substring, and with the same numbers !!
// !! need a 256 sized hash
public class Solution {
 /**
  * @param source: A string
  * @param target: A string
  * @return: A string denote the minimum window
  *          Return "" if there is no such a string
  */
 public void preprocess(String target, int[] reg){
     for(int i=0;i<target.length();i++)
     reg[target.charAt(i)]++;
 }
 // key: array hash !!
 public boolean check(int[] hash, int[] reg){
	 for(int i=0;i<256;i++)
		 if(hash[i]<reg[i]) return false;
	 return true;
 }
 public String minWindow(String source, String target) {
     // write your code
	 int[] reg= new int[256];
	 int[] hash=new int[256];
	 preprocess(target,reg);
	 int a=0,b=0;
	 int min=Integer.MAX_VALUE,mina=a,minb=b;
	 // key block !!
	 while(b<source.length()){
		 hash[source.charAt(b)]++;
		 while(check(hash,reg)){
			 if(min>b-a+1){
				 min=b-a+1;
				 mina=a;
				 minb=b;
			 }
			 hash[source.charAt(a)]--;
			 a++;
		 }
		 b++; 
	 }
	 return min==Integer.MAX_VALUE?"":source.substring(mina,minb+1);
 }
}