package lintcode;
import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
public class Solution {
    //1 5   10  50  100 500 1000
    //I V   X   L   C   D   M
    /**
     * @param n The integer
     * @return Roman representation
     */
    public static String intToRoman(int n) {
        // Write your code here
        String ans="";
        String basic="IVXLCDMMM";// less code
        int index=0;
        while(n!=0){
            int digit=n%10;
            String one=basic.substring(index,index+1);
            String five=basic.substring(index+1,index+2);
            String ten=basic.substring(index+2,index+3);
            if(digit==1) ans=one+ans;
            else if(digit==2) ans=one+one+ans;
            else if(digit==3) ans=one+one+one+ans;
            else if(digit==4) ans=one+five+ans;
            else if(digit==5) ans=five+ans;
            else if(digit==6) ans=five+one+ans;
            else if(digit==7) ans=five+one+one+ans;
            else if(digit==8) ans=five+one+one+one+ans;
            else if(digit==9) ans=one+ten+ans;
            index+=2;// 5 based
            n/=10;
        }
        return ans;
    }
    public static void main(String[] args){
    	System.out.println(intToRoman(1800));
    }
}