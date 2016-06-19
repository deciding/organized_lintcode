import java.util.*;

   class ListNode {
      int val;
      ListNode next;
      ListNode(int val,ListNode n) {
          this.val = val;
          this.next = n;
      }
  }
  
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
	public static ListNode findMid(ListNode node){
		if(node==null||node.next==null) return node;
		ListNode slow=node;
		ListNode fast=node.next;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public static ListNode merge(ListNode node1, ListNode node2){
		ListNode dummy=new ListNode(0,null);
		ListNode cur=dummy;
		while(node1!=null&&node2!=null){
			if(node1.val<node2.val){
				cur.next=node1;
				node1=node1.next;
			}
			else{
				cur.next=node2;
				node2=node2.next;
			}
			cur=cur.next;
		}
		cur.next=node1==null?node2:node1;
		return dummy.next;
	}
    public static ListNode sortList(ListNode head) {  
        // write your code here
    	if(head==null||head.next==null) return head;
    	ListNode right=findMid(head);
    	if(right!=null) {
    		ListNode tmp=right.next;
    		right.next=null;
    		right=tmp;
    	}
    	ListNode left=sortList(head);
    	right=sortList(right);
    	return merge(left,right);
    }
    public static void main(String[] args){
    	//ListNode head=new ListNode(1,new ListNode(7,new ListNode(5,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(6,null)))))));
    	ListNode head=null;
    	sortList(head);
    	while(head!=null){
    		System.out.println(head.val);
    		head=head.next;
    	}
    }
}
