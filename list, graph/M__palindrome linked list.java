package lintcode;
import java.util.*;

// key: findMid, reverse, compare element by element
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x,ListNode n) { val = x; next=n;}
  }
 
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
	public static ListNode findMid(ListNode head){
		if(head==null) return head;
		ListNode slow=head, fast=head.next;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public static ListNode reverse(ListNode node){
		ListNode prev=null;
		while(node!=null){
			ListNode tmp=node.next;
			node.next=prev;
			prev=node;
			node=tmp;
		}
		return prev;
	}
    public static boolean isPalindrome(ListNode head) {
        // Write your code here
    	if(head==null) return true;
    	ListNode mid=findMid(head);
    	mid.next=reverse(mid.next);
    	
    	ListNode cur1=head,cur2=mid.next;
    	while(cur1!=null&&cur2!=null){
    		if(cur1.val!=cur2.val) return false;
    		cur1=cur1.next;
    		cur2=cur2.next;
    	}
    	return true;
    }
    public static void main(String[] args){
    	ListNode head=new ListNode(1,new ListNode(0,new ListNode(3,new ListNode(4,new ListNode(0,new ListNode(1,null))))));
    	isPalindrome(head);
    }
}