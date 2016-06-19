import java.util.*;
// duplicates are allowed
//because if if A[a]==A[mid], we cannot know it's on the left or right
//[2,1,2,2,2], [2,2,2,1,2]
public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if(A==null) return false;
        for(int i=0;i<A.length;i++)
        if(A[i]==target) return true;
        return false;
    }
}
