/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
    	ListNode dummy= new ListNode(0);
    	dummy.next=head;
    	ListNode prev=dummy;
    	while(prev!=null&&prev.next!=null&&prev.next.next!=null){
    		if(prev.next.val==prev.next.next.val){
    			int val=prev.next.val;// key !! trace this value
	  		    while(prev.next!=null&&prev.next.val==val)
	  			    prev.next=prev.next.next;
    		}
    		else prev=prev.next;// key !! must have else, otherwise 111222 will lead to 2, which is wrong
    	}
    	return dummy.next;
    }
}
