//cannot use divide operation
public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> ans= new ArrayList<Long>();
        long factor=1;
        for(int i=0;i<A.size();i++){
            ans.add(factor);
            factor*=A.get(i);
        }
        factor=1;
        for(int i=A.size()-1;i>=0;i--){
            ans.set(i,ans.get(i)*factor);// simplify to get result in the second loop !!
            factor*=A.get(i);
        }
        return ans;
    }
}
