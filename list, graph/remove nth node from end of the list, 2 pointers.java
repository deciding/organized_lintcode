/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
// key !! different from find the nth node, we must use dummy !!
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode walker=dummy;
        ListNode runner=dummy;
        while(n>0){
            runner=runner.next;
            n--;
        }
        while(runner.next!=null){
            walker=walker.next;
            runner=runner.next;
        }
        walker.next=walker.next.next;
        return dummy.next;
    }
}
