public class Solution {
    /* you may need to use some attributes here */
    class FenwickTree{
        long[] ft;
        int n;
        int LSB(int x){ return x&(-x);}
        FenwickTree(int[] A){
            n=A.length;
            ft=new long[n+1];
            for(int i=0;i<n;i++) modify(i,A[i]);
        }
        void modify(int index, int diff){
            index++;
            while(index<n+1){
                ft[index]+=diff;
                index+=LSB(index);
            }
        }
        long query(int i){
            i++;
            long sum=0;
            while(i>0){
                sum+=ft[i];
                i-=LSB(i);
            }
            return sum;
        }
    }
    FenwickTree ft;
    int[] A;
    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // write your code here
        ft=new FenwickTree(A);
        this.A=A;
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return ft.query(end)-ft.query(start-1);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        ft.modify(index,value-A[index]);
        A[index]=value;
    }
}
