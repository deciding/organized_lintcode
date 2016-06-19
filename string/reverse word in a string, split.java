public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if(s==null) return "";
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
            sb.append(arr[i]).append(" ");
        return sb.length()==0?"":sb.substring(0,sb.length()-1);
    }
}
