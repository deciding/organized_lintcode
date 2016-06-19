//?? How can you optimize your algorithm if one array is very large and the other is very small?
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    //challenge: what if one is very large, another is very small? maybe use binary search
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int indexA=0,indexB=0;
        while(indexA<A.size()&&indexB<B.size()){
            if(A.get(indexA)<B.get(indexB))
                result.add(A.get(indexA++));
            else result.add(B.get(indexB++));
        }
        while(indexA<A.size())
            result.add(A.get(indexA++));
        while(indexB<B.size())
            result.add(B.get(indexB++));
        return result;
    }
}
