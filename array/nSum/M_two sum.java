import java.util.*;

// we use hashmap because no need sort
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            int key=target-numbers[i];
            if(hm.containsKey(key))
                return new int[]{hm.get(key)+1, i+1};
            hm.put(numbers[i],i);
        }
        return new int[]{};
    }
}