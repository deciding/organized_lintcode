import java.util.*;
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    // recursive
    public static void helper(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> item, ArrayList<Integer> nums, int index){
    	ans.add(new ArrayList<Integer>(item));
    	if(index==nums.size()) return;
    	for(int i=index;i<nums.size();i++){
    		if(i!=index&&nums.get(i)==nums.get(i-1)) continue;// much easier, since we only need to care about 'index'
    		item.add(nums.get(i));
    		helper(ans,item,nums,i+1);
    		item.remove(item.size()-1);
    	}
    }
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
    	Collections.sort(S);
    	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> item=new ArrayList<Integer>();
    	helper(ans,item,S,0);
    	return ans;
    }
    //iterative
    public static ArrayList<ArrayList<Integer>> subsetsWithDup_i(ArrayList<Integer> S) {
        // write your code here
        Collections.sort(S);
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
        ans.add(new ArrayList<Integer>());
        int i=0, cnt;
        while(i<S.size()){
            cnt=1;
            while(i+cnt<S.size()&&S.get(i)==S.get(i+cnt)) cnt++;
            int size=ans.size();
            for(int index=0;index<size;index++){
                ArrayList<Integer> tmp=new ArrayList<Integer>(ans.get(index));
                for(int n=0;n<cnt;n++){
                    tmp.add(S.get(i));
                    ans.add(new ArrayList<Integer>(tmp));
                }
            }
            i+=cnt;
        }
        return ans;
    }
    public static void main(String[] args){
    	System.out.println(subsetsWithDup(new ArrayList<Integer>(Arrays.asList(1,2,2))));
    }
}
