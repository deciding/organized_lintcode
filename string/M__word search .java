import java.util.*;
// not use visited but change to dummy and change back !!

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    // DFS !!
	static int[] dm=new int[]{1,0,-1,0};
	static int[] dn=new int[]{0,-1,0,1};
	public static boolean helper(char[][] board, String word, int i, int j, int k){
		if(k==word.length()) return true;
		if(i<0||j<0||i>=board.length||j>=board[0].length) return false;
		if(board[i][j]!=word.charAt(k)) return false;
		char tmp=board[i][j];
		board[i][j]='$';// key !! then we do not need to use visited !!
		boolean ans=false;
		for(int index=0;index<4;index++)
				if(ans=helper(board,word,i+dm[index],j+dn[index],k+1)) break;
		board[i][j]=tmp;
		return ans;
	}
    public static boolean exist(char[][] board, String word) {
        // write your code here
    	if(board==null||board.length==0||board[0].length==0) return false;
    	if(word.length()==0) return true;
    	boolean ans=false;
    	for(int i=0;i<board.length;i++)
    		for(int j=0;j<board[0].length;j++)
    			 if(ans=helper(board,word,i,j,0)) return true;
    	return ans;
    }
    public static void main(String[] args){
    	System.out.println(exist(new char[][]{
    			{'A','B','C','C'},
    			{'S','C','C','C'},
    			{'A','C','C','C'},
    	},"ABCCCCC"));
    }
}