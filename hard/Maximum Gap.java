class Solution {
    //create bin for range, not a single value, then there won't be too mucn bins
    //each bin we just need to find max/min, no need sort them
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0||nums.length==1) return 0;
        int n=nums.length;
        int max=nums[0],min=nums[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int range=(max-min)/(n-1);
        if(range==0) range++;
        int[] binMax=new int[n];
        int[] binMin=new int[n];
        for(int i=0;i<n;i++){
            binMax[i]=Integer.MIN_VALUE;
            binMin[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            int bin=(nums[i]-min)/range;
            binMax[bin]=Math.max(binMax[bin],nums[i]);
            binMin[bin]=Math.min(binMin[bin],nums[i]);
        }
        int prev=0;
        int ans=0;
        for(int i=1;i<n;i++)
        if(binMax[i]!=Integer.MIN_VALUE){
            ans=Math.max(ans,binMin[i]-binMax[prev]);
            prev=i;
        }
        return ans;
    }
}
