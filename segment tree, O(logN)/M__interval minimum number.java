import java.util.*;

  class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
 //st store index not value
 class SegmentTree{
	 int[] A;
	 int[] st;
	 private int left(int p){ return p<<1; }
	 private int right(int p){ return (p<<1)+1; }
	 public SegmentTree(int[] A){
		 this.A=A;
		 this.st=new int[4*A.length];
		 build(1,0,A.length-1);
	 }
	 public void build(int p, int L,int R){
		 if(L==R) {
			 st[p]=L;
			 return;
		 }
		 int mid=(L+R)/2;
		 int l=left(p),r=right(p);
		 build(l,L,mid);
		 build(r,mid+1,R);
		 st[p]=A[st[l]]<A[st[r]]?st[l]:st[r];
	 }
	 public int rmq(int p, int L, int R, int i, int j){
		 if(i<=L&&R<=j) return st[p];
		 if(R<i||j<L) return -1;
		 int mid=(L+R)/2;
		 int p1= rmq(left(p),L,mid,i,j);
		 int p2= rmq(right(p),mid+1,R,i,j);
		 if(p1==-1) return p2;
		 if(p2==-1) return p1;
		 return A[p1]<A[p2]?p1:p2;
	 }
	 public int rmq(int i, int j){
		 return rmq(1,0,A.length-1,i,j);
	 }
 }
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public static ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
    	SegmentTree st= new SegmentTree(A);
    	ArrayList<Integer> ans= new ArrayList<Integer>();
    	for(int i=0;i<queries.size();i++){
    		Interval q=queries.get(i);
    		int p=st.rmq(q.start, q.end);
    		if(p!=-1)
    		ans.add(A[p]);
    	}
    	return ans;
    }
    public static void main(String[] args){
    	ArrayList<Interval> qs=new ArrayList<Interval>();
    	qs.add(new Interval(1,2));qs.add(new Interval(0,4));qs.add(new Interval(2,4));
    	System.out.println(intervalMinNumber(new int[]{1,2,7,8,5},qs));
    }
}