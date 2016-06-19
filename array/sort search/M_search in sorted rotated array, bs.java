import java.util.*;
public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public static int search(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0) return -1;
        int a=0, b=A.length-1;
        while(a+1<b){
            int mid=(a+b)/2;
            if(A[mid]==target) return mid;
            // 4 cases !!
            if(A[mid]>A[a]){
                if(A[a]<=target&&target<=A[mid]) b=mid;
                else a=mid;
            }
            else {
                if(A[mid]<=target&&target<=A[b]) a=mid;
                else b=mid;
            }
        }
        if(A[a]==target) return a;
        if(A[b]==target) return b;
        return -1;
    }
    public static void main(String[] args){
        System.out.println(search(new int[]{2,3,1},1));
    }
}
