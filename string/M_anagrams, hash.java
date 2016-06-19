public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    // word->anagram array-> hash
    public List<String> anagrams(String[] strs) {
        // write your code here
        ArrayList<String> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<String>> map=new HashMap<>(); 
        for(String str:strs){
            int hash=0;
            int[] count=new int[26];
            for(int i=0;i<str.length();i++)
                count[str.charAt(i)]++;
            for(int i=0;i<26;i++)
                hash=hash*31+count[i];// !! actually 31 may not be correct, since the count is not limited to 26(31)
            if(map.containsKey(hash))
                map.get(hash).add(str);
            else {
                ArrayList<String> temp=new ArrayList<>();
                temp.add(str);
                map.put(hash,temp);
            }
        }
        for(ArrayList<String> strList:map.values())
            if(strList.size()>1)
            ans.addAll(strList);// !! addAll
        return ans;
    }

}