public class Solution {
    //1. get the k1, k2 subarr with for loop
    //2. get the greatest of length k1/k2
    //3. merge with lexical order comes first(better lexical order, better larger chance, also resolve die)
    /**
     * @param nums1 an integer array of length m with digits 0-9
     * @param nums2 an integer array of length n with digits 0-9
     * @param k an integer and k <= m + n
     * @return an integer array
     */
    public int[] maxNumber(int[] num, int k){
        if(k==num.length) return num;
        if(k==0) return new int[0];
        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int x:num) ans.add(x);
        int kk=num.length-k;
        for(int i=0;i<kk;i++)
            for(int j=0;j<ans.size()-1;j++)
            if(ans.get(j)<ans.get(j+1)){
                ans.remove(j);
                break;
            }
        int[] arr=new int[k];
        for(int i=0;i<k;i++) arr[i]=ans.get(i);
        return arr;
    }
    public int[] merge(int[] nums1, int[] nums2){
        if(nums1.length==0) return nums2;
        if(nums2.length==0) return nums1;
        int n1=nums1.length,n2=nums2.length;
        int n=n1+n2;
        int[] ans= new int[n];
        int i=0,j=0,index=0;
        while(i<n1&&j<n2){
            if(greater(nums1,i,nums2,j))
                ans[index++]=nums1[i++];
            else ans[index++]=nums2[j++];
        }
        while(i<n1)
            ans[index++]=nums1[i++];
        while(j<n2)
            ans[index++]=nums2[j++];   
        return ans;
    }
    public boolean greater(int[] nums1,int p1, int[] nums2, int p2){
        for(int i=0;i<Math.min(nums1.length-p1,nums2.length-p2);i++)
            if(nums1[p1+i]>nums2[p2+i]) return true;
            else if(nums1[p1+i]<nums2[p2+i]) return false;
        if(nums1.length-p1>nums2.length-p2)
            return true;
        return false;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // Write your code here
        if(k==0) return new int[0];
        int[] max=new int[k];
        for(int k1=0;k1<=Math.min(k, nums1.length);k1++){
            int k2=k-k1;
            if(k2>nums2.length) continue;
            int[] ans1=maxNumber(nums1,k1);
            int[] ans2=maxNumber(nums2,k2);
            int[] cur=merge(ans1,ans2);
            if(greater(cur,0,max,0)) max=cur;
        }
        return max;
    }
}
