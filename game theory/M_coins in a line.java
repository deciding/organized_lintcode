package lintcode;
import java.util.*;
public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        return n%3!=0?true:false;//anyone who can control there are only 3 times coins after his round
    }
}