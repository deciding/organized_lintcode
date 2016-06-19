import java.util.*;

  class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
 class SegmentTree{
	 int[] A;
	 long[] st;
	 private int left(int p){ return p<<1; }
	 private int right(int p){ return (p<<1)+1; }
	 public SegmentTree(int[] A){
		 this.A=A;
		 this.st=new long[4*A.length];
		 build(1,0,A.length-1);
	 }
	 public void build(int p, int L,int R){
		 if(L==R) {
			 st[p]=A[L];
			 return;
		 }
		 int mid=(L+R)/2;
		 int l=left(p),r=right(p);
		 build(l,L,mid);
		 build(r,mid+1,R);
		 st[p]=st[l]+st[r];
	 }
	 public long rsq(int p, int L, int R, int i, int j){
		 if(i<=L&&R<=j) return st[p];
		 if(R<i||j<L) return 0;
		 int mid=(L+R)/2;
		 long sum1= rsq(left(p),L,mid,i,j);
		 long sum2= rsq(right(p),mid+1,R,i,j);
		 return sum1+sum2;
	 }
	 public long rsq(int i, int j){
		 return rsq(1,0,A.length-1,i,j);
	 }
 }
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public static ArrayList<Long> intervalSum(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
    	SegmentTree st= new SegmentTree(A);
    	ArrayList<Long> ans= new ArrayList<Long>();
    	for(int i=0;i<queries.size();i++){
    		Interval q=queries.get(i);
    		long sum=st.rsq(q.start, q.end);
    		ans.add(sum);
    	}
    	return ans;
    }
    public static void main(String[] args){
    	ArrayList<Interval> qs=new ArrayList<Interval>();
    	qs.add(new Interval(1,2));qs.add(new Interval(0,4));qs.add(new Interval(2,4));
    	System.out.println(intervalSum(new int[]{1,2,7,8,5},qs));
    }
}