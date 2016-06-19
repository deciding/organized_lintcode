// for only one pass, if meet a new max, clear and add
class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        int max=0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0;i<dictionary.length;i++){
            if(dictionary[i].length()>max){
                result.clear();
                max=dictionary[i].length();
                result.add(dictionary[i]);
            }
            else if(dictionary[i].length()==max){
                result.add(dictionary[i]);
            }
        }
        return result;
    }
};
