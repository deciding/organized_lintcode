import java.util.*;

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
	public static void swap(char[] chars, int i, int j){
		char tmp= chars[i];
		chars[i]=chars[j];
		chars[j]=tmp;
	}
    public static void sortLetters(char[] chars) {
        //write your code here
    	int index=0;
    	for(int i=0;i<chars.length;i++)
    		if(Character.isLowerCase(chars[i])) swap(chars,i,index++);
    }
    public static void main(String[] args){
    	char[] chars=new char[]{'A'};
    	sortLetters(chars);
    	System.out.println(Arrays.toString(chars));
    }
}
