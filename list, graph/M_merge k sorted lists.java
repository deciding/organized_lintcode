package lintcode;
import java.util.*;
//1. D&C
//2.heap

  //Definition for ListNode.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }
 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
	public ListNode merge2lists(ListNode node1,ListNode node2){
		if(node1==null) return node2;
		if(node2==null) return node1;
		ListNode ans=new ListNode(0);
		ListNode cur1=node1,cur2=node2,dummy=new ListNode(0),cur3=dummy;
		
		while(cur1!=null && cur2!=null){
			ListNode tmp=new ListNode(0);
			if(cur1.val<cur2.val){
				tmp.val=cur1.val;
				cur1=cur1.next;
			}
			else{
				tmp.val=cur2.val;
				cur2=cur2.next;
			}
			cur3.next=tmp;
			cur3=cur3.next;
		}
		cur3.next=cur1==null?cur2:cur1;
		return dummy.next;
	}
	//key block !! if merge one by one: O(n^2*m), n: number of lists, m: number of elements in one list
	// if use below function O(2*n*m)
	public ListNode mergeLists(List<ListNode> lists,int i,int j) {  
		if(i==j) return lists.get(i);
		if(i==j-1) return merge2lists(lists.get(i),lists.get(j));
		ListNode left=mergeLists(lists,i,(i+j)/2);
		ListNode right=mergeLists(lists,(i+j)/2+1,j);
		return merge2lists(left,right);
	}
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
    	if(lists.size()==0) return null;
        return mergeLists(lists,0,lists.size()-1);
    }
}
