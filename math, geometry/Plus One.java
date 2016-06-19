public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        int carry=1;
        for(int pos =digits.length-1;pos>=0;pos--){
            digits[pos]+=carry;
            if(digits[pos]==10) {
                digits[pos]=0;
                carry=1;
            }
            else carry=0;
        }
        if(carry==1){
            int[] digits2= new int[digits.length+1];
            digits2[0]=1;
            for(int i=1;i<digits2.length;i++)
                digits2[i]=digits[i-1];
            return digits2;
        }
        return digits;
    }
}