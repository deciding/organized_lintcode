public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    void swap(int[] nums, int i, int j){
        int tmp=nums[i];nums[i]=nums[j];nums[j]=tmp;
    }
    void reverse(int[] nums,int i, int j){
        int x=i,y=j;
        while(x<y)
        swap(nums,x++,y--);
    }
    int partition(int[] nums, int i, int j){
        int k=i;
        for(int index=i;index<=j;index++)
        if(nums[index]<nums[i])
            swap(nums,index,++k);
        swap(nums,k,i);
        return k;
    }
    int findMedian(int[] nums, int i, int j, int k){
        int m=partition(nums,i,j);
        if(m==k) return k;
        if(m<k) return findMedian(nums,m+1,j,k);
        return findMedian(nums,i,m-1,k);
    }
    void intersect(int[] nums, int k){
        int[] ans=new int[nums.length];
        if(nums.length%2==0){
            int ai=0,bi=1;
            int aj=k+1,bj=0;
            while(ai<=k&&bi<nums.length){
                ans[bi]=nums[ai];
                ai++;bi+=2;
            }
            while(aj<nums.length&&bj<nums.length){
                ans[bj]=nums[aj];
                aj++;bj+=2;
            }
            for(int i=0;i<nums.length;i++)
            nums[i]=ans[nums.length-1-i];
            return;
        }
        int ai=0,bi=0;
        int aj=k+1,bj=1;
        while(ai<=k&&bi<nums.length){
            ans[bi]=nums[ai];
            ai++;bi+=2;
        }
        while(aj<nums.length&&bj<nums.length){
            ans[bj]=nums[aj];
            aj++;bj+=2;
        }
        for(int i=0;i<nums.length;i++)
        nums[i]=ans[i];
        return;
    }
    public void wiggleSort(int[] nums) {
        // Write your code here
        int n=nums.length;
        if(n<2) return;
        int k=(n-1)/2;
        findMedian(nums,0,n-1,k);
        int mid=nums[k];
        int j=k;
        for(int index=k;index>=0;index--)
        if(nums[index]==mid)
            swap(nums,index,j--);
        j=k;
        for(int index=k+1;index<n;index++)
        if(nums[index]==mid)
            swap(nums,index,j++);
        intersect(nums,k);
    }
}
