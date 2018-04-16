public class Solution {
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    class SegmentTree{
        int[] st;
        int n;
        int left(int p){return p<<1;}
        int right(int p){return (p<<1)+1;}
        
        SegmentTree(int n){
            st=new int[4*n];
            this.n=n;
        }
        int update(int p, int L, int R, int index){
            if(L==R&&R==index) return ++st[p];
            if(index<L||R<index) return st[p];
            int mid=(L+R)/2;
            int l=update(left(p),L,mid,index);
            int r=update(right(p),mid+1,R,index);
            return st[p]=l+r;
        }
        int query(int p, int L, int R, int i, int j){
            if(i<=L&&R<=j) return st[p];
            if(j<L||R<i) return 0;
            int mid=(L+R)/2;
            return query(left(p),L,mid,i,j)+query(right(p),mid+1,R,i,j);
        }
    }
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        SegmentTree st=new SegmentTree(10003);
        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=0;i<A.length;i++){
            st.update(1,0,10000,A[i]);
            ans.add(st.query(1,0,10000,0,A[i]-1));
        }
        return ans;
    }
}
