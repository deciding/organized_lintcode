import java.util.*;

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x,ListNode n) {
          val = x;
          next = n;
      }
  }
 
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // write your code here
    	//getLength()
    	if(head==null) return head;
    	ListNode cur=head;
    	int len=0;
    	while(cur!=null){
    		cur=cur.next;
    		len++;
    	}
    	k=(len-k%len)%len; // key !! rotate right to left always easier, last %len is to make len to 0
    	if(len==0||k==0) return head;
    	cur=head;
    	while(k>1){
    		cur=cur.next;
    		k--;
    	}
    	ListNode h=cur.next;
    	cur.next=null;
    	cur=h;
    	while(cur.next!=null)
    		cur=cur.next;
    	cur.next=head;
    	return h;
    }
    public static void main(String[] args){
    	ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
    	rotateRight(head,12);
    }
}