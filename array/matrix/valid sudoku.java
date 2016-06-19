package lintcode;
import java.util.*;
class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public static boolean isValidSudoku(char[][] board) {
        int bits=0;
        for(int i=0;i<9;i++){
            bits=0;
            for(int j=0;j<9;j++)
            if(board[i][j]!='.')
                if((bits&(1<<(board[i][j]-'0')))!=0)
                return false;
                else bits|=(1<<(board[i][j]-'0'));
        }
        for(int i=0;i<9;i++){
            bits=0;
            for(int j=0;j<9;j++)
            if(board[j][i]!='.')
            	if((bits&(1<<(board[j][i]-'0')))!=0)
                    return false;
                    else bits|=(1<<(board[j][i]-'0'));
        }
        for(int i=0;i<9;i++){
            bits=0;
            int r=i/3*3;
            int c=i%3*3;
            for(int j=0;j<9;j++){
            int r1=j/3;
            int c1=j%3;
            if(board[r+r1][c+c1]!='.')
            	if((bits&(1<<(board[r+r1][c+c1]-'0')))!=0)
                    return false;
                    else bits|=(1<<(board[r+r1][c+c1]-'0'));
            }
        }
        return true;
    }
    
    public static void main(String[] args){
    	char[][] board={"....5..1.".toCharArray(),".4.3.....".toCharArray(),".....3..1".toCharArray(),
    			"8......2.".toCharArray(),"..2.7....".toCharArray(),".15......".toCharArray(),
    			".....2...".toCharArray(),".2.9.....".toCharArray(),"..4......".toCharArray()};
    	System.out.println(isValidSudoku(board));
    }
    
};