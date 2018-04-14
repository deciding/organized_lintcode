package lintcode;
import java.util.*;

//separate pos and neg, then rearrange !
class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        if(A.length<=2) return;
        int posCnt=0;
        // key !!, partition first !! return count of positive numbers
        for(int i=0;i<A.length;i++)
        if(A[i]>0){
            int tmp=A[i];
            A[i]=A[posCnt];
            A[posCnt++]=tmp;
        }
        //key !! very heuristic
        int posi,negi;
        if(posCnt*2<=A.length){
            posi=0;
            negi=posCnt%2==0?posCnt+1:posCnt;
        }
        else {
            posi=1;
            negi=posCnt%2==0?posCnt:posCnt+1;
        }
        while(posi<posCnt&&negi<A.length){
            int tmp=A[posi];
            A[posi]=A[negi];
            A[negi]=tmp;
            posi+=2;
            negi+=2;
        }
   }
}
