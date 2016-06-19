// Moore's voting algorithm greedy
//cannot be used for most appearance number
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int generateCandidate(ArrayList<Integer> nums){
        if(nums.size()==0) return -1;
        int maj=0;
        int count =0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==nums.get(maj)){
                count++;
            }
            else if(count==0){
                maj=i;
                count=1;
            }
            else count--;
        }
        return maj;
    }
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int cand=generateCandidate(nums);
        int count=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==nums.get(cand)) count++;
        }
        return nums.get(cand);
    }
}

