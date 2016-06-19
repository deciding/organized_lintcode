package lintcode;
import java.util.*;
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public static int partition(int k, int i, int j, ArrayList<Integer> numbers){
        if(i==j&&k==1)return i;
        if(i>j||k<1) return -1;
        //key block !!
        int index=i+1;
        for(int a=i+1;a<=j;a++)
        if(numbers.get(a)>=numbers.get(i)){
            int temp=numbers.get(a);
            numbers.set(a,numbers.get(index));
            numbers.set(index,temp);
            index++;
        }
        
        int temp=numbers.get(i);
        numbers.set(i,numbers.get(index-1));
        numbers.set(index-1,temp);
        if(index-i==k) return index-1;
        else if(index-i>k) return partition(k,i,index-2,numbers);
        else return partition(k-index+i,index,j,numbers);
    }
    public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        int index=partition(k,0,numbers.size()-1,numbers);
        return index>=0?numbers.get(index):-1;
    }
    public static void main(String[] args){
    }
};