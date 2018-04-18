public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    long merge(int[]A, int i, int j){
        if(i>=j) return 0;
        int mid=(i+j)/2;
        long ans=merge(A,i,mid)+merge(A,mid+1,j);
        int[] arr=new int[j-i+1];
        int a=i,b=mid+1,index=0;
        while(a<=mid&&b<=j){
            if(A[a]<=A[b]) arr[index++]=A[a++];
            else {
                arr[index++]=A[b++];
                ans+=mid-a+1;
            }
        }
        while(a<=mid) arr[index++]=A[a++];
        while(b<=j) arr[index++]=A[b++];
        for(int x=0;x<arr.length;x++)
        A[x+i]=arr[x];
        return ans;
    }
    public long reversePairs(int[] A) {
        // Write your code here
        return merge(A,0,A.length-1);
    }
}
