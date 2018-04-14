package lintcode;
import java.util.*;
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int a=1,b=n;
        while(a+1<b){
            int mid=(a+b)/2;
            if(!SVNRepo.isBadVersion(mid)) a=mid;
            else b=mid;
        }
        if(!SVNRepo.isBadVersion(a)) return b;
        else return a;
    }
}
