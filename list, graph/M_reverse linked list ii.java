import java.util.*;

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x, ListNode n) {
          val = x;
          next = n;
      }
  }
 
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
	public static ListNode reverse(ListNode node, int len){
		if(node==null) return node;
		ListNode prev=null,cur=node,tmp;
		while(len>0){
			tmp=cur.next;
			cur.next=prev;
			prev=cur;
			cur=tmp;
			len--;
		}
		node.next=cur;// change 1 !!
		return prev;
	}
    public static ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
    	if(head==null||head.next==null||m==n) return head;
    	ListNode dummy= new ListNode(0,null);
    	dummy.next=head;
    	ListNode cur=dummy;
    	int index=m;
    	while(index>1){
    		cur=cur.next;
    		index--;
    	}
    	cur.next=reverse(cur.next,n-m+1);// change 2 !!
    	return dummy.next; // change 3 !!
    }
    public static void main(String[] args){
    	ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
    	reverseBetween(head,5,5);
    }
}