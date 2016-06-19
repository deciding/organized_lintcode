package lintcode;
import java.util.*;
// candidate map, key set, delList, count map !!

//O(N) time bcoz there are altogether N counts for all k counters, -- will take O(N)
//O(k) space
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        if(k==1||nums.size()==0) return Integer.MIN_VALUE;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.size();i++){
        	ArrayList<Integer> delList=new ArrayList<Integer>();
            Set<Integer> ks=hm.keySet();
            if(hm.containsKey(nums.get(i)))
            hm.put(nums.get(i),hm.get(nums.get(i))+1);
            else if(hm.size()<k-1)//simplify !!
            hm.put(nums.get(i),1);
            else for(int key:ks){
                hm.put(key,hm.get(key)-1);
                if(hm.get(key)==0)
                delList.add(key);// used for simplify !!
            }
            for(int key:delList)// used for simplify !!
            hm.remove(key);
        }
        HashMap<Integer,Integer> cnt=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.size();i++)
        if(hm.containsKey(nums.get(i))){
        if(cnt.containsKey(nums.get(i)))
        cnt.put(nums.get(i),cnt.get(nums.get(i))+1);
        else cnt.put(nums.get(i),1);
        }
        int max=0,val=0;
        for(int key:cnt.keySet())
        if(cnt.get(key)>max){
            max=cnt.get(key);
            val=key;
        }
        return val;
    }
}
