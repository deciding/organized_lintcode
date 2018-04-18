/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    
    Stack<Integer> sti;
    Stack<List<NestedInteger>> stl;
    int index;
    List<NestedInteger> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        sti=new Stack<Integer>();
        stl=new Stack<List<NestedInteger>>();
        list=nestedList;
        index=0;
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return list.get(index++).getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while(true){
            if(list.isEmpty()||index==list.size()){
                if(sti.isEmpty()) break;
                index=sti.pop();
                list=stl.pop();
                index++;
            }
            else if(!list.get(index).isInteger()){
                sti.push(index);
                stl.push(list);
                list=list.get(index).getList();
                index=0;
            }
            else 
                return true;
        }
        return false;
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */
