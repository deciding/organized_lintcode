import java.util.*;
class SegmentTree{
	 int[] st;
	 int n;
	 private int left(int p){ return p<<1; }
	 private int right(int p){ return (p<<1)+1; }
	 public SegmentTree(int n){
		 this.st=new int[4*(n+1)];
		 this.n=n;
		 build(1,0,n);
	 }
	 public void build(int p, int L,int R){
		 if(L==R) {
			 st[p]=0;
			 return;
		 }
		 int mid=(L+R)/2;
		 int l=left(p),r=right(p);
		 build(l,L,mid);
		 build(r,mid+1,R);
		 st[p]=0;
	 }
	 public int update(int p, int L, int R, int index){
		 if(index==L&&index==R) return ++st[p];
		 if(R<index||index<L) return st[p];// !! difference from query !!
		 int mid=(L+R)/2;
		 int cnt1= update(left(p),L,mid,index);
		 int cnt2= update(right(p),mid+1,R,index);
		 return st[p]=cnt1+cnt2;
	 }
	 public void update(int val){
		 update(1,0,n,val);
	 }
	 public int rsq(int p, int L, int R, int i, int j){
		 if(i<=L&&R<=j) return st[p];
		 if(R<i||j<L) return 0;
		 int mid=(L+R)/2;
		 int cnt1= rsq(left(p),L,mid,i,j);
		 int cnt2= rsq(right(p),mid+1,R,i,j);
		 return cnt1+cnt2;
	 }
	 public int rsq(int i, int j){
		 if(i>j) return 0;
		 return rsq(1,0,n,i,j);
	 }
}
public class Solution {
	   /**
	     * @param A: An integer array
	     * @return: The number of element in the array that 
	     *          are smaller that the given integer
	     */
	    public static ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
	        // write your code here
	    	SegmentTree seg=new SegmentTree(10000);
	    	for(int i=0;i<A.length;i++)
	    		seg.update(A[i]);
	    	ArrayList<Integer> ans= new ArrayList<Integer>();
	    	for(int i=0;i<queries.length;i++)
	    		ans.add(seg.rsq(0,queries[i]-1));
	    	return ans;
	    }
	    public static void main(String[] args){
	    	System.out.println(countOfSmallerNumber(new int []{1,2,7,8,5}, new int[]{1,8,5})); 
	    }
	}
