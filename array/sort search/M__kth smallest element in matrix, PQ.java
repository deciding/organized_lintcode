package lintcode;
import java.util.*;
public class Solution {
    //heap: put all candidates inside
    //2 cases: h>w,w>h...I am too lazy
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    // !! O(klogM), actually M should be Max(m,n)
    // !! put all rows first value inside. we do not just put inside the top-left corner, and every poll offer right and bottom,
    //because that we cause duplicate offer
    public class Element{
        public int r, c, val;
        public Element(int row,int col,int value){
            r=row;c=col;val=value;
        }
    }
    Comparator<Element> cmp=new Comparator<Element>(){
        public int compare(Element a, Element b){
            return a.val-b.val;
        }
    };
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<Element> hp=new PriorityQueue<Element>(matrix.length,cmp);
        for(int i=0;i<matrix.length;i++)
        hp.offer(new Element(i,0,matrix[i][0]));
        Element el=null;
        for(int i=0;i<k;i++){
            el=hp.poll();
            if(el.c+1<matrix[0].length)
            hp.offer(new Element(el.r,el.c+1,matrix[el.r][el.c+1]));
        }
        return el==null?-1:el.val;
    }
}