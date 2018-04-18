public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    int houseRobber(int[] nums, int a, int b){
        if(a==b) return nums[a];
        if(a+1==b) return Math.max(nums[a],nums[b]);
        if(a+2==b) return Math.max(nums[a+1], nums[a]+nums[b]);
        int ppp=nums[a],pp=nums[a+1],p=nums[a]+nums[a+2];
        int ans=0;
        for(int i=a+3;i<=b;i++){
        ans=Math.max(ppp,pp)+nums[i];
        ppp=pp;pp=p;p=ans;
        }
        return Math.max(p,pp);
    }
    public int houseRobber2(int[] nums) {
        // write your code here
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        return Math.max(houseRobber(nums,0,n-2),houseRobber(nums,1,n-1));
    }
}
